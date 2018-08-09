package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.UUIDUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.InternationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.InternationalPassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.booking.NtsBookingResultVO;
import com.apin.qunar.order.domain.international.createOrder.*;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignParam;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignResultVO;
import com.apin.qunar.order.service.international.NtsCreateOrderService;
import com.apin.qunar.order.service.international.NtsSearchRefundChangeSignService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class NtsCreateOrderServiceImpl extends NtsApiService<NtsCreateOrderParam, ApiResult<NtsCreateOrderResultVO>> implements NtsCreateOrderService {

    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private InternationalPassengerDaoImpl internationalPassengerDao;
    @Autowired
    private NtsSearchRefundChangeSignService ntsSearchRefundChangeSignService;
    @Autowired
    private OrderConfig orderConfig;

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.order";
    }

    @Override
    protected TypeReference<ApiResult<NtsCreateOrderResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsCreateOrderResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsCreateOrderResultVO> createOrder(final NtsCreateOrderRequestBO ntsCreateOrderRequest, final NtsCreateOrderParam ntsCreateOrderParam, final NtsBookingResultVO ntsBookingResult) {
        ApiResult<NtsCreateOrderResultVO> apiResult = execute(ntsCreateOrderParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("国际订单下单失败,params:{},原因:{}", JSON.toJSON(ntsCreateOrderRequest), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        if (apiResult.isSuccess()) {
            ApiResult<NtsSearchRefundChangeSignResultVO> ntsSearchRefundChangeSignResultApiResult = ntsSearchRefundChangeSignService.searchRefundChangeSign(buildNtsSearchRefundChangeSignParam(ntsCreateOrderRequest, ntsBookingResult));
            saveOrderToDb(ntsCreateOrderRequest, apiResult.getResult(), ntsCreateOrderParam, ntsBookingResult, ntsSearchRefundChangeSignResultApiResult.getResult());
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), NtsCreateOrderResultVO.class));
    }

    private void saveOrderToDb(final NtsCreateOrderRequestBO ntsCreateOrderRequest, final NtsCreateOrderResultVO ntsCreateOrderResult, final NtsCreateOrderParam ntsCreateOrderParam, final NtsBookingResultVO ntsBookingResult, final NtsSearchRefundChangeSignResultVO ntsSearchRefundChangeSignResultApiResult) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
        TransactionStatus status = transactionManager.getTransaction(definition);//事务开始
        InternationalOrder internationalOrder = buildInternationalOrder(ntsCreateOrderRequest, ntsCreateOrderResult, ntsCreateOrderParam, ntsBookingResult, ntsSearchRefundChangeSignResultApiResult);
        List<InternationalPassenger> internationalPassengers = buildInternationalPassengers(ntsCreateOrderResult.getOrderNo(), ntsCreateOrderParam);
        try {
            internationalOrderDao.insert(internationalOrder);
            for (InternationalPassenger internationalPassenger : internationalPassengers) {
                internationalPassengerDao.insert(internationalPassenger);
            }
            transactionManager.commit(status);//提交事务
        } catch (Exception e) {
            transactionManager.rollback(status);//事务回滚
            log.error("保存国际订单到数据库异常,ntsCreateOrderResult:{},ntsCreateOrderParam:{}", ntsCreateOrderResult, ntsCreateOrderParam, e);
        }
    }

    private InternationalOrder buildInternationalOrder(final NtsCreateOrderRequestBO ntsCreateOrderRequest, final NtsCreateOrderResultVO ntsCreateOrderResult, final NtsCreateOrderParam ntsCreateOrderParam, final NtsBookingResultVO ntsBookingResult, final NtsSearchRefundChangeSignResultVO ntsSearchRefundChangeSignResultApiResult) {
        InternationalOrder internationalOrder = new InternationalOrder();
        internationalOrder.setId(IDGenerator.getUniqueId());
        internationalOrder.setMerchantNo(ntsCreateOrderRequest.getMerchantNo());
        internationalOrder.setOrderNo(ntsCreateOrderResult.getOrderNo());
        Contact contact = ntsCreateOrderParam.getContact();
        if (contact != null) {
            internationalOrder.setContactName(contact.getName());
            internationalOrder.setContactMobile(contact.getMobile());
            internationalOrder.setContactNum(String.valueOf(contact.getMobCountryCode()));
            internationalOrder.setContactEmail(contact.getEmail());
        }
        internationalOrder.setPayAmount((int) Double.parseDouble(ntsCreateOrderResult.getTotalPrice()));
        internationalOrder.setPayStatus(OrderStatusEnum.BOOK_OK.getCode());
        internationalOrder.setPayDeadline(ntsCreateOrderResult.getPayDeadline());
        if (ntsBookingResult.getTgqRule() != null) {
            NtsBookingResultVO.TgqRule tgqRule = ntsBookingResult.getTgqRule();
            NtsSearchRefundChangeSignResultVO.StandardDigitalTgqInfo standardDigitalTgqInfo = ntsSearchRefundChangeSignResultApiResult.getStandardDigitalTgqInfo();
            if (standardDigitalTgqInfo != null && standardDigitalTgqInfo.getRefund() != null & CollectionUtils.isNotEmpty(standardDigitalTgqInfo.getRefund().getList())) {
                internationalOrder.setReturnFee(standardDigitalTgqInfo.getRefund().getList().get(0).getPrice());
            } else {
                internationalOrder.setReturnFee(0);
            }
            internationalOrder.setReturnText(tgqRule.getRefund());
            if (standardDigitalTgqInfo != null && standardDigitalTgqInfo.getChange() != null & CollectionUtils.isNotEmpty(standardDigitalTgqInfo.getChange().getList())) {
                internationalOrder.setReturnFee(standardDigitalTgqInfo.getChange().getList().get(0).getPrice());
            } else {
                internationalOrder.setChangeFee(0);
            }
            internationalOrder.setChangeText(tgqRule.getChange());
        }
        if (CollectionUtils.isNotEmpty(ntsBookingResult.getSegments())) {
            NtsBookingResultVO.Segment segment = ntsBookingResult.getSegments().get(0);

            internationalOrder.setGoFlightNum(segment.getFlightNumber());
            internationalOrder.setGoFlightTime(ntsCreateOrderRequest.getDuration());
            internationalOrder.setGoCarrierCode(ntsCreateOrderRequest.getCarrierCode());
            internationalOrder.setGoCarrierName(ntsCreateOrderRequest.getCarrierFullName());
            internationalOrder.setGoStopCnt(StringUtils.isBlank(segment.getStopCities()) ? 0 : 1);
            internationalOrder.setGoDeptAirportCode(segment.getDepartPort());
            internationalOrder.setGoArriAirportCode(segment.getArrivePort());
            internationalOrder.setGoDeptCity(ntsCreateOrderRequest.getDepCityName());
            internationalOrder.setGoArriCity(ntsCreateOrderRequest.getArrCityName());
            internationalOrder.setGoDeptAirportName(ntsCreateOrderRequest.getDepAirportName());
            internationalOrder.setGoArriAirportName(ntsCreateOrderRequest.getArrAirportName());
            internationalOrder.setGoDeptTerminal(ntsCreateOrderRequest.getDepTerminal());
            internationalOrder.setGoArriTerminal(ntsCreateOrderRequest.getArrTerminal());
            internationalOrder.setGoDeptDate(segment.getDepartDate());
            internationalOrder.setGoDeptTime(segment.getDepartTime());
            internationalOrder.setGoArriTime(segment.getArriveTime());
            internationalOrder.setGoCabin(getCabinName(segment.getCabinClass()));
        }
        if (CollectionUtils.isNotEmpty(ntsBookingResult.getSegments()) && ntsBookingResult.getSegments().size() > 1) {
            NtsBookingResultVO.Segment segment = ntsBookingResult.getSegments().get(1);
            internationalOrder.setBackFlightNum(segment.getFlightNumber());
            internationalOrder.setBackFlightTime(ntsCreateOrderRequest.getBackDuration());
            internationalOrder.setBackCarrierCode(ntsCreateOrderRequest.getBackCarrierCode());
            internationalOrder.setBackCarrierName(ntsCreateOrderRequest.getBackCarrierFullName());
            internationalOrder.setBackStopCnt(StringUtils.isBlank(segment.getStopCities()) ? 0 : 1);
            internationalOrder.setBackDeptAirportCode(segment.getDepartPort());
            internationalOrder.setBackArriAirportCode(segment.getArrivePort());
            internationalOrder.setBackDeptCity(ntsCreateOrderRequest.getBackDepCityName());
            internationalOrder.setBackArriCity(ntsCreateOrderRequest.getBackArrCityName());
            internationalOrder.setBackDeptAirportName(ntsCreateOrderRequest.getBackDepAirportName());
            internationalOrder.setBackArriAirportName(ntsCreateOrderRequest.getBackArrAirportName());
            internationalOrder.setBackDeptTerminal(ntsCreateOrderRequest.getBackDepTerminal());
            internationalOrder.setBackArriTerminal(ntsCreateOrderRequest.getBackArrTerminal());
            internationalOrder.setBackDeptDate(segment.getDepartDate());
            internationalOrder.setBackDeptTime(segment.getDepartTime());
            internationalOrder.setBackArriTime(segment.getArriveTime());
            internationalOrder.setBackCabin(getCabinName(segment.getCabinClass()));
        }
        internationalOrder.setOperator(ntsCreateOrderRequest.getAccount());
        internationalOrder.setPackName(ntsCreateOrderRequest.getPackName());
        return internationalOrder;
    }

    private String getCabinName(int cabinCode) {
        String cabinName = "";
        switch (cabinCode) {
            case 1:
                cabinName = "经济舱";
                break;
            case 2:
                cabinName = "商务舱";
                break;
            case 3:
                cabinName = "头等舱";
                break;
        }
        return cabinName;
    }

    private List<InternationalPassenger> buildInternationalPassengers(final String orderNo, final NtsCreateOrderParam ntsCreateOrderParam) {
        List<InternationalPassenger> internationalPassengers = new ArrayList<>();
        List<Passenger> passengers = ntsCreateOrderParam.getPassengerList();
        for (Passenger passenger : passengers) {
            InternationalPassenger internationalPassenger = new InternationalPassenger();
            internationalPassenger.setId(UUIDUtil.getUUID());
            internationalPassenger.setOrderNo(orderNo);
            internationalPassenger.setName(passenger.getName());
            internationalPassenger.setAgeType(passenger.getAgeType());
            internationalPassenger.setCardNo(passenger.getCardNum());
            internationalPassenger.setCardType(passenger.getCardType());
            internationalPassenger.setGender("M".equalsIgnoreCase(passenger.getGender()) ? 1 : 0);
            internationalPassenger.setBirthday(passenger.getBirthday());
            internationalPassenger.setMobileNo(passenger.getMobile());
            internationalPassenger.setNationality(passenger.getNationality());
            internationalPassenger.setCardExpired(passenger.getCardExpired());
            internationalPassengers.add(internationalPassenger);
        }
        return internationalPassengers;
    }

    private NtsSearchRefundChangeSignParam buildNtsSearchRefundChangeSignParam(final NtsCreateOrderRequestBO ntsCreateOrderRequest, final NtsBookingResultVO ntsBookingResult) {
        NtsSearchRefundChangeSignParam ntsSearchRefundChangeSignParam = new NtsSearchRefundChangeSignParam();
        ntsSearchRefundChangeSignParam.setSource(orderConfig.getInternationalSource());
        ntsSearchRefundChangeSignParam.setPricekey(ntsCreateOrderRequest.getBookingTagKey());
        ntsSearchRefundChangeSignParam.setPlaneType(ntsBookingResult.getSegments().get(0).getAircraftCode());
        ntsSearchRefundChangeSignParam.setPassengerType("adult");
        return ntsSearchRefundChangeSignParam;
    }
}