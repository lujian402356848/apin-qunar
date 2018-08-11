package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.utils.UUIDUtil;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.BookingFlightInfo;
import com.apin.qunar.order.domain.national.booking.BookingResultVO;
import com.apin.qunar.order.domain.national.booking.TgqShowData;
import com.apin.qunar.order.domain.national.createOrder.CreateOrderParam;
import com.apin.qunar.order.domain.national.createOrder.CreateOrderRequestBO;
import com.apin.qunar.order.domain.national.createOrder.CreateOrderResultVO;
import com.apin.qunar.order.domain.national.createOrder.FlightInfo;
import com.apin.qunar.order.service.national.CreateOrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
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
public class CreateOrderServiceImpl extends ApiService<CreateOrderParam, ApiResult<CreateOrderResultVO>> implements CreateOrderService {
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private NationalOrderDaoImpl natioanlOrderDao;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.order";
    }

    @Override
    protected TypeReference<ApiResult<CreateOrderResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<CreateOrderResultVO>>() {
        };
    }

    @Override
    public ApiResult<CreateOrderResultVO> createOrder(final CreateOrderRequestBO createOrderRequest, final CreateOrderParam createOrderParam, final BookingResultVO bookingResult) {
        ApiResult<CreateOrderResultVO> apiResult = execute(createOrderParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("国内订单下单失败,params:{},原因:{}", JSON.toJSON(createOrderParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), "航班价格发生变更，请重新搜索");
        }
        if (apiResult.isSuccess()) {
            saveOrderToDb(createOrderRequest, apiResult.getResult(), bookingResult, createOrderParam);
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), CreateOrderResultVO.class));
    }

    private void saveOrderToDb(final CreateOrderRequestBO createOrderRequest, final CreateOrderResultVO createOrderResult, final BookingResultVO bookingResult, final CreateOrderParam createOrderParam) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
        TransactionStatus status = transactionManager.getTransaction(definition);//事务开始
        NationalOrder nationalOrder = buildNatioanlOrder(createOrderResult, bookingResult, createOrderParam, createOrderRequest);
        List<NationalPassenger> nationalPassengers = buildNationalPassenger(createOrderResult, createOrderRequest);
        try {
            natioanlOrderDao.insert(nationalOrder);
            for (NationalPassenger nationalPassenger : nationalPassengers) {
                nationalPassengerDao.insert(nationalPassenger);
            }
            transactionManager.commit(status);//提交事务
        } catch (Exception e) {
            transactionManager.rollback(status);//事务回滚
            log.error("保存国内订单到数据库异常,createOrderResult:{},createOrderParam:{}", createOrderResult, createOrderParam, e);
        }
    }

    private NationalOrder buildNatioanlOrder(final CreateOrderResultVO createOrderResult, final BookingResultVO bookingResult, final CreateOrderParam createOrderParam, final CreateOrderRequestBO createOrderRequest) {
        NationalOrder natioanlOrder = new NationalOrder();
        FlightInfo flightInfo = createOrderParam.getFlightInfo();
        natioanlOrder.setId(createOrderResult.getId());
        natioanlOrder.setMerchantNo(createOrderRequest.getMerchantNo());
        natioanlOrder.setOrderNo(createOrderResult.getOrderNo());
        natioanlOrder.setOrderRelationNo(createOrderRequest.getOrderRelationNo());
        natioanlOrder.setClientSite(createOrderParam.getClientSite());
        natioanlOrder.setTag(createOrderParam.getProductTag());
        natioanlOrder.setDeptCity(flightInfo.getDeptCity());
        natioanlOrder.setArriCity(flightInfo.getArriCity());
        natioanlOrder.setDeptDate(flightInfo.getDeptDate());
        natioanlOrder.setDeptTime(new StringBuilder(flightInfo.getDeptTime()).insert(2, ":").toString());
        natioanlOrder.setArriTime(new StringBuilder(flightInfo.getArriTime()).insert(2, ":").toString());
        natioanlOrder.setCabin(flightInfo.getCabin());
        natioanlOrder.setFlightNum(flightInfo.getFlightNum());
        natioanlOrder.setContactName(createOrderParam.getContact());
        natioanlOrder.setContactMobile(createOrderParam.getContactMob());
        natioanlOrder.setContactNum(createOrderParam.getContactPreNum());
        natioanlOrder.setContactEmail(createOrderParam.getContactEmail());
        natioanlOrder.setFuelTax(createOrderParam.getFuelTax());
        natioanlOrder.setConstructionFee(createOrderParam.getConstructionFee());
        natioanlOrder.setPrintPrice(createOrderParam.getPrintPrice());
//        natioanlOrder.setIncomePrice(bookingResult.getPriceInfo().getIncomePrice());
        natioanlOrder.setPublishPrice(createOrderParam.getyPrice());
        natioanlOrder.setPayOrderId(String.valueOf(createOrderResult.getId()));
        natioanlOrder.setPayAmount(createOrderResult.getNoPayAmount());
        natioanlOrder.setPayStatus(OrderStatusEnum.BOOK_OK.getCode());
        natioanlOrder.setOperator(createOrderRequest.getAccount());
        if (CollectionUtils.isNotEmpty(bookingResult.getFlightInfo())) {
            BookingFlightInfo bookingFlightInfo = bookingResult.getFlightInfo().get(0);
            natioanlOrder.setActFlightNum(bookingFlightInfo.getActFlightNum());
            natioanlOrder.setFlightTime(bookingFlightInfo.getFlightTimes());
            natioanlOrder.setCarrierCode(bookingFlightInfo.getCarrier());
            natioanlOrder.setCarrierName(bookingFlightInfo.getCarrierName());
            natioanlOrder.setStopCnt(bookingFlightInfo.getStops());
            natioanlOrder.setDeptAirportCode(bookingFlightInfo.getDpt());
            natioanlOrder.setArriAirportCode(bookingFlightInfo.getArr());
            natioanlOrder.setDeptAirportName(bookingFlightInfo.getDptAirport());
            natioanlOrder.setArriAirportName(bookingFlightInfo.getArrAirport());
            natioanlOrder.setDeptTerminal(bookingFlightInfo.getDptTerminal());
            natioanlOrder.setArriTerminal(bookingFlightInfo.getArrTerminal());
            natioanlOrder.setCodeShare(bookingFlightInfo.isCodeShare() ? 1 : 0);
        }
        if (bookingResult.getTgqShowData() != null && CollectionUtils.isNotEmpty(bookingResult.getTgqShowData().getTgqPointCharges())) {
            TgqShowData tgqShowData = bookingResult.getTgqShowData();
            natioanlOrder.setReturnFee(tgqShowData.getTgqPointCharges().get(0).getReturnFee());
            natioanlOrder.setReturnText(tgqShowData.getReturnText());
            natioanlOrder.setChangeFee(tgqShowData.getTgqPointCharges().get(0).getChangeFee());
            natioanlOrder.setChangeText(tgqShowData.getChangeText());
        }
        return natioanlOrder;
    }

    private List<NationalPassenger> buildNationalPassenger(final CreateOrderResultVO createOrderResult, final CreateOrderRequestBO createOrderRequest) {
        List<NationalPassenger> nationalPassengers = new ArrayList<>();
        List<CreateOrderRequestBO.Passenger> passengers = createOrderRequest.getPassengers();
        for (CreateOrderRequestBO.Passenger passenger : passengers) {
            NationalPassenger nationalPassenger = new NationalPassenger();
            nationalPassenger.setId(UUIDUtil.getUUID());
            nationalPassenger.setMerchantNo(createOrderRequest.getMerchantNo());
            nationalPassenger.setOrderNo(createOrderResult.getOrderNo());
            nationalPassenger.setName(passenger.getName());
            nationalPassenger.setAgeType(passenger.getAgeType());
            nationalPassenger.setCardNo(passenger.getCardNo());
            nationalPassenger.setCardType(passenger.getCardType());
            nationalPassenger.setGender(passenger.getSex());
            nationalPassenger.setBirthday(passenger.getBirthday());
            nationalPassenger.setMobileNo(passenger.getMobileNo());
            nationalPassengers.add(nationalPassenger);
        }
        return nationalPassengers;
    }
}