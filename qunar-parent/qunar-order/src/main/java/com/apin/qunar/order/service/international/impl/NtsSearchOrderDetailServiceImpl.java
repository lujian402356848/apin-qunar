package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.dao.model.Airport;
import com.apin.qunar.basic.service.AirportService;
import com.apin.qunar.order.common.enums.NtsOrderStatusEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.InternationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.InternationalPassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailParam;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailResultVO;
import com.apin.qunar.order.service.international.NtsSearchOrderDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NtsSearchOrderDetailServiceImpl extends NtsApiService<NtsSearchOrderDetailParam, ApiResult<NtsSearchOrderDetailResultVO>> implements NtsSearchOrderDetailService {
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private InternationalPassengerDaoImpl internationalPassengerDao;
    @Autowired
    private AirportService airportService;

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.detail";
    }

    @Override
    protected TypeReference<ApiResult<NtsSearchOrderDetailResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsSearchOrderDetailResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsSearchOrderDetailResultVO> searchOrderDetail(final NtsSearchOrderDetailParam ntsSearchOrderDetailParam) {
        ApiResult<NtsSearchOrderDetailResultVO> apiResult = execute(ntsSearchOrderDetailParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国际订单明细异常,param:{},原因:{}", JSON.toJSON(ntsSearchOrderDetailParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        setSearchOrderDetailResult(apiResult.getResult());
        formatString(apiResult.getResult());
        formatCityCode(apiResult.getResult());
        syncOrderStatusToDb(apiResult.getResult());
        return apiResult;
    }


    private void formatCityCode(NtsSearchOrderDetailResultVO apiResults) {
        NtsSearchOrderDetailResultVO.FlightInfo flightInfo = apiResults.getFlightInfo();
        if (flightInfo == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(flightInfo.getSegments())) {
            List<NtsSearchOrderDetailResultVO.Segment> segments = flightInfo.getSegments();
            for (NtsSearchOrderDetailResultVO.Segment segment : segments) {
                String depAirport = segment.getDepAirport();
                String arrAirport = segment.getArrAirport();
                Airport departAirport = airportService.queryByCode(depAirport);
                Airport arrayAirport = airportService.queryByCode(arrAirport);
                if (departAirport == null || arrayAirport == null||StringUtils.isBlank(departAirport.getCityName())||StringUtils.isBlank(arrayAirport.getCityName())) {
                    segment.setDptCityName(depAirport);
                    segment.setArrCityName(arrAirport);
                    continue;
                }
                segment.setDptCityName(departAirport.getCityName());
                segment.setArrCityName(arrayAirport.getCityName());
            }
        }
    }

    private void formatString(NtsSearchOrderDetailResultVO apiResults) {
        NtsSearchOrderDetailResultVO.FlightInfo flightInfo = apiResults.getFlightInfo();
        if (flightInfo == null) {
            return;
        }
        NtsSearchOrderDetailResultVO.Tgq tgq = flightInfo.getTgqRule();
        if (tgq == null) {
            return;
        }
        if (StringUtils.isNotBlank(tgq.getBaggage())) {
            tgq.setBaggage(tgq.getBaggage().replaceAll("去哪儿", "爱拼机"));
        }
        if (StringUtils.isNotBlank(tgq.getChange())) {
            tgq.setChange(tgq.getChange().replaceAll("去哪儿", "爱拼机"));
        }
        if (StringUtils.isNotBlank(tgq.getOther())) {
            tgq.setOther(tgq.getOther().replaceAll("去哪儿", "爱拼机"));
        }
        if (StringUtils.isNotBlank(tgq.getRefund())) {
            tgq.setRefund(tgq.getRefund().replaceAll("去哪儿", "爱拼机"));
        }
    }

    private void setSearchOrderDetailResult(NtsSearchOrderDetailResultVO ntsSearchOrderDetailResult) {
        if (ntsSearchOrderDetailResult == null) {
            return;
        }
        ntsSearchOrderDetailResult.setOrderStatus(NtsOrderStatusEnum.valueOfDesc(Integer.parseInt(ntsSearchOrderDetailResult.getOrderStatus())));
        InternationalOrder internationalOrder = internationalOrderDao.queryByOrderNo(ntsSearchOrderDetailResult.getOrderNo());
        if (internationalOrder != null) {
            ntsSearchOrderDetailResult.setTotalPrice(internationalOrder.getPayAmount().toString());
            ntsSearchOrderDetailResult.setPayDeadline(internationalOrder.getPayDeadline());
            NtsSearchOrderDetailResultVO.FlightInfo flightInfo = ntsSearchOrderDetailResult.getFlightInfo();
            if (flightInfo == null) {
                return;
            }
            if (internationalOrder.getReturnFee() != null) {
                flightInfo.setReturnFee(internationalOrder.getReturnFee());
            } else {
                flightInfo.setReturnFee(0);
            }
            flightInfo.setReturnText(internationalOrder.getReturnText());
            if (internationalOrder.getChangeFee() != null) {
                flightInfo.setChangeFee(internationalOrder.getChangeFee());
            } else {
                flightInfo.setChangeFee(0);
            }
            flightInfo.setPackName(internationalOrder.getPackName());
            flightInfo.setChangeText(internationalOrder.getChangeText());
            if (CollectionUtils.isNotEmpty(flightInfo.getSegments())) {
                NtsSearchOrderDetailResultVO.Segment segment = flightInfo.getSegments().get(0);
                segment.setFlightTime(formatDate(internationalOrder.getGoFlightTime()));
                segment.setCarrierCode(internationalOrder.getGoCarrierCode());
                segment.setCarrierName(internationalOrder.getGoCarrierName());
                segment.setHasStop(internationalOrder.getGoStopCnt() > 0);
                segment.setDptAirportName(internationalOrder.getGoDeptAirportName());
                segment.setArrAirportName(internationalOrder.getGoArriAirportName());
                segment.setDeptDate(internationalOrder.getGoDeptDate());
                segment.setDptTerminal(internationalOrder.getGoDeptTerminal());
                segment.setArrTerminal(internationalOrder.getGoArriTerminal());
                segment.setArrTime(internationalOrder.getGoArriTime());
                segment.setActFlightNum(internationalOrder.getGoActFlightNum());
            }
            if (CollectionUtils.isNotEmpty(flightInfo.getSegments()) && flightInfo.getSegments().size() > 1) {
                NtsSearchOrderDetailResultVO.Segment segment = flightInfo.getSegments().get(1);
                segment.setFlightTime(formatDate(internationalOrder.getBackFlightTime()));
                segment.setCarrierCode(internationalOrder.getBackCarrierCode());
                segment.setCarrierName(internationalOrder.getBackCarrierName());
                segment.setHasStop(internationalOrder.getBackStopCnt() > 0);
                segment.setDptAirportName(internationalOrder.getBackDeptAirportName());
                segment.setArrAirportName(internationalOrder.getBackArriAirportName());
                segment.setDeptDate(internationalOrder.getBackDeptDate());
                segment.setDptTerminal(internationalOrder.getBackDeptTerminal());
                segment.setArrTerminal(internationalOrder.getBackArriTerminal());
                segment.setArrTime(internationalOrder.getBackArriTime());
                segment.setActFlightNum(internationalOrder.getBackActFlightNum());
            }
        }
        List<InternationalPassenger> internationalPassengers = internationalPassengerDao.queryByOrderNo(ntsSearchOrderDetailResult.getOrderNo());
        List<NtsSearchOrderDetailResultVO.Passenger> passengerInfo = ntsSearchOrderDetailResult.getPassengerInfo();
        for (NtsSearchOrderDetailResultVO.Passenger passenger : passengerInfo) {
            Optional<InternationalPassenger> passengerOptional = internationalPassengers.stream().filter(p -> p.getCardNo().equals(passenger.getCardNum()) && p.getName().equals(passenger.getName())).findFirst();
            if (passengerOptional.isPresent()) {
                passenger.setCardExpired(passengerOptional.get().getCardExpired());
            }
        }
    }

    private String formatDate(String minuteTime) {
        if (StringUtils.isNotBlank(minuteTime)) {
            return (Integer.parseInt(minuteTime) / 60) + "小时" + (Integer.parseInt(minuteTime) % 60) + "分钟";
        }
        return minuteTime;
    }

    private void syncOrderStatusToDb(NtsSearchOrderDetailResultVO orderDetail) {
        if (orderDetail == null) {
            return;
        }
        String orderNo = orderDetail.getOrderNo();
        String status = orderDetail.getOrderStatus();
        if (StringUtils.isBlank(orderNo) || StringUtils.isBlank(status)) {
            return;
        }
        try {
            switch (status) {
                case "出票完成":
                    String ticketNo = getTicketNo(orderDetail.getPassengerInfo());
                    if (StringUtils.isNotBlank(ticketNo)) {
                        internationalOrderDao.updateStatusAndTicketNo(orderNo, ticketNo, NtsOrderStatusEnum.TICKET_OK.getCode());
                        log.info("国际订单状态已同步到数据，同步后的状态为:【出票完成】");
                    }
                    break;
                case "订单取消":
                    internationalOrderDao.updateStatus(orderNo, NtsOrderStatusEnum.CANCEL_OK.getCode());
                    log.info("国际订单状态已同步到数据，同步后的状态为:【订单取消】");
                    break;
            }
        } catch (Exception e) {
            log.error("同步国际订单状态到数据库异常,status:{}", status, e);
        }
    }

    private String getTicketNo(List<NtsSearchOrderDetailResultVO.Passenger> passengers) {
        StringBuilder ticketNoStr = new StringBuilder(100);
        for (NtsSearchOrderDetailResultVO.Passenger passenger : passengers) {
            if (StringUtils.isBlank(passenger.getETicketNum())) {
                continue;
            }
            ticketNoStr.append(",");
            ticketNoStr.append(passenger.getName());
            ticketNoStr.append("*");
            ticketNoStr.append(passenger.getETicketNum());
        }
        return ticketNoStr.length() < 1 ? "" : ticketNoStr.substring(1);
    }
}
