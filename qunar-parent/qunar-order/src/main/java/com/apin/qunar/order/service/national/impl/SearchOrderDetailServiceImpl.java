package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.impl.NationalReturnOrderDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.dao.model.NationalPassenger;
import com.apin.qunar.order.dao.model.NationalReturnOrder;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailResultVO;
import com.apin.qunar.order.service.national.SearchOrderDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SearchOrderDetailServiceImpl extends ApiService<SearchOrderDetailParam, ApiResult<SearchOrderDetailResultVO>> implements SearchOrderDetailService {
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;
    @Autowired
    private NationalReturnOrderDaoImpl nationalReturnOrderDao;

    @Override
    protected String getTag() {
        return "flight.national.tts.order.info.detail.get";
    }

    @Override
    protected TypeReference<ApiResult<SearchOrderDetailResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SearchOrderDetailResultVO>>() {
        };
    }

    @Override
    public ApiResult<SearchOrderDetailResultVO> searchOrderDetail(final SearchOrderDetailParam searchOrderDetailParam) {
        ApiResult<SearchOrderDetailResultVO> apiResult = execute(searchOrderDetailParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国内订单明细异常,param:{},原因:{}", JSON.toJSON(searchOrderDetailParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        setSearchOrderDetailResult(searchOrderDetailParam.getOrderNo(), apiResult.getResult());
        apiResult.setResult(buildTgqMsg(apiResult.getResult()));
        syncOrderStatusToDb(apiResult.getResult());
        return apiResult;
    }

    private void setSearchOrderDetailResult(String orderNo, SearchOrderDetailResultVO searchOrderDetailResult) {
        if (searchOrderDetailResult == null || CollectionUtils.isEmpty(searchOrderDetailResult.getFlightInfo())) {
            return;
        }
        NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(orderNo);
        NationalReturnOrder nationalReturnOrder = nationalReturnOrderDao.queryByOrderNo(orderNo);
        Integer returnFee = 0;
        if (nationalReturnOrder != null) {
            returnFee = nationalReturnOrder.getReturnFee();
        }

        if (nationalOrder == null) {
            orderNo = searchOrderDetailResult.getDetail().getParentOrderNo();
            nationalOrder = nationalOrderDao.queryByOrderNo(orderNo);
        }
        if (nationalOrder != null) {
            SearchOrderDetailResultVO.OrderDetail orderDetail = searchOrderDetailResult.getDetail();
            if (orderDetail != null) {
                orderDetail.setClientSite(nationalOrder.getClientSite());
                orderDetail.setOrderId(nationalOrder.getId());
                orderDetail.setCodeShare(nationalOrder.getCodeShare() != null && nationalOrder.getCodeShare() == 1);
            }
            SearchOrderDetailResultVO.FlightInfo flightInfo = searchOrderDetailResult.getFlightInfo().get(0);
            flightInfo.setActFlightNum(nationalOrder.getActFlightNum());
            flightInfo.setFlightTime(nationalOrder.getFlightTime());
            flightInfo.setCarrierCode(nationalOrder.getCarrierCode());
            flightInfo.setCarrierName(nationalOrder.getCarrierName());
            flightInfo.setHasStop(nationalOrder.getStopCnt() > 0);
            flightInfo.setDptAirportName(nationalOrder.getDeptAirportName());
            flightInfo.setArrAirportName(nationalOrder.getArriAirportName());
            flightInfo.setDptTerminal(nationalOrder.getDeptTerminal());
            flightInfo.setArrTerminal(nationalOrder.getArriTerminal());
            flightInfo.setDeptDate(nationalOrder.getDeptDate());
            flightInfo.setDeptTime(nationalOrder.getDeptTime());
            flightInfo.setArrTime(nationalOrder.getArriTime());
            flightInfo.setReturnFee(nationalOrder.getReturnFee() == null ? 0 : nationalOrder.getReturnFee());
            flightInfo.setReturnText(nationalOrder.getReturnText());
            flightInfo.setChangeFee(nationalOrder.getChangeFee() == null ? 0 : nationalOrder.getChangeFee());
            flightInfo.setChangeText(nationalOrder.getChangeText());
            flightInfo.setTag(nationalOrder.getTag());
            if (searchOrderDetailResult.getContacterInfo() != null) {
                searchOrderDetailResult.getContacterInfo().setMobile(nationalOrder.getContactMobile());
            }
        }
        List<NationalPassenger> nationalPassengers = nationalPassengerDao.queryByOrderNo(orderNo);
        List<SearchOrderDetailResultVO.Passenger> passengers = searchOrderDetailResult.getPassengers();
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            List<NationalPassenger> searchPassengers = nationalPassengers.stream().filter(p -> p.getName().equals(passenger.getName())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(searchPassengers)) {
                passenger.setBirthday(searchPassengers.get(0).getBirthday());
                passenger.setGender(searchPassengers.get(0).getGender());
                passenger.setMobileNo(searchPassengers.get(0).getMobileNo());
                passenger.setCardNum(searchPassengers.get(0).getCardNo());
                passenger.setCardType(searchPassengers.get(0).getCardType());
            }
        }
        List<SearchOrderDetailResultVO.PassengerType> passengerTypes = searchOrderDetailResult.getPassengerTypes();
        if (CollectionUtils.isNotEmpty(passengerTypes)) {
            SearchOrderDetailResultVO.PassengerType PassengerType = passengerTypes.get(0);
            PassengerType.setRefundPrices(returnFee * passengers.size());
        }
    }

    private SearchOrderDetailResultVO buildTgqMsg(SearchOrderDetailResultVO searchOrderDetailResultVO) {
        if (StringUtils.isNotBlank(searchOrderDetailResultVO.getOther().getTgqMsg())) {
            searchOrderDetailResultVO.getOther().setTgqMsg(searchOrderDetailResultVO.getOther().getTgqMsg().replaceAll("<br />", " "));
        }
        return searchOrderDetailResultVO;
    }

    private void syncOrderStatusToDb(SearchOrderDetailResultVO orderDetail) {
        if (orderDetail == null || orderDetail.getDetail() == null) {
            return;
        }
        String orderNo = orderDetail.getDetail().getOrderNo();
        String status = orderDetail.getDetail().getStatus();
        if (StringUtils.isBlank(orderNo) || StringUtils.isBlank(status)) {
            return;
        }
        try {
            switch (status) {
                case "出票完成":
                    String ticketNo = getTicketNo(orderDetail.getPassengers());
                    if (StringUtils.isNotBlank(ticketNo)) {
                        nationalOrderDao.updateStatusAndTicketNo(orderDetail.getDetail().getOrderNo(), ticketNo, OrderStatusEnum.TICKET_OK.getCode());
                    }
                    break;
                case "改签完成":
                    nationalOrderDao.updateStatus(orderNo, OrderStatusEnum.CHANGE_OK.getCode());
                    break;
                case "退款完成":
                    nationalOrderDao.updateStatus(orderNo, OrderStatusEnum.REFUND_OK.getCode());
                    break;
                case "订单取消":
                    nationalOrderDao.updateStatus(orderNo, OrderStatusEnum.CANCEL_OK.getCode());
                    break;
            }
        } catch (Exception e) {
            log.error("同步国内订单状态到数据库异常,status:{}", status, e);
        }
    }

    private String getTicketNo(List<SearchOrderDetailResultVO.Passenger> passengers) {
        StringBuilder ticketNoStr = new StringBuilder(100);
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            if (StringUtils.isBlank(passenger.getTicketNo())) {
                continue;
            }
            ticketNoStr.append(",");
            ticketNoStr.append(passenger.getName());
            ticketNoStr.append("/");
            ticketNoStr.append(passenger.getTicketNo());
        }
        return ticketNoStr.length() < 1 ? "" : ticketNoStr.substring(1);
    }
}
