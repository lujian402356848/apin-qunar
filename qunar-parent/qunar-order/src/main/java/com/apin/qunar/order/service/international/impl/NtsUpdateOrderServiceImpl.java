package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.enums.NtsOrderStatusEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.InternationalPassengerDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.dao.model.InternationalPassenger;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailParam;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailResultVO;
import com.apin.qunar.order.service.international.NtsSearchOrderDetailService;
import com.apin.qunar.order.service.international.NtsUpdateOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @outhor lujian
 * @create 2018-07-09 12:24
 */
@Slf4j
@Service
public class NtsUpdateOrderServiceImpl implements NtsUpdateOrderService {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;
    @Autowired
    private InternationalPassengerDaoImpl internationalPassengerDao;
    @Autowired
    private NtsSearchOrderDetailService ntsSearchOrderDetailService;
    @Autowired
    private SmsService smsService;

    @Override
    public boolean updatePayInfo(final String orderNo, final String payId, final int orderStatus, final String payTime) {
        boolean result = false;
        try {
            result = internationalOrderDao.updatePayInfo(orderNo, payId, orderStatus, payTime);
        } catch (Exception e) {
            log.error("更新订单支付信息异常,orderNo:{},payId:{},payStatus:{},payTime:{}", orderNo, payId, orderStatus, payTime, e);
        }
        return result;
    }

    @Override
    public boolean updateStatus(final String orderNo, final int payStatus) {
        boolean result = false;
        if (StringUtils.isBlank(orderNo)) {
            return result;
        }
        try {
            if (payStatus == NtsOrderStatusEnum.TICKET_OK.getCode()) {//状态为5说明出票成功，需要获取票号更新到数据库中
                List<NtsSearchOrderDetailResultVO.Passenger> passengers = getPassengers(orderNo);
                String ticketNo = getTicketNo(passengers);
                if (StringUtils.isNotBlank(ticketNo)) {
                    result = internationalOrderDao.updateStatusAndTicketNo(orderNo, ticketNo, payStatus);
                    sendSms(orderNo, passengers);
                }
            } else {
                result = internationalOrderDao.updateStatus(orderNo, payStatus);
            }
        } catch (Exception e) {
            log.error("更新订单状态失败,orderNo:{},payStatus:{}", orderNo, payStatus, e);
        }
        return result;
    }

    private List<NtsSearchOrderDetailResultVO.Passenger> getPassengers(final String orderNo) {
        List<NtsSearchOrderDetailResultVO.Passenger> passengers = null;
        NtsSearchOrderDetailParam ntsSearchOrderDetailParam = new NtsSearchOrderDetailParam();
        ntsSearchOrderDetailParam.setSource(orderConfig.getInternationalSource());
        ntsSearchOrderDetailParam.setOrderNo(orderNo);
        try {
            ApiResult<NtsSearchOrderDetailResultVO> apiResult = ntsSearchOrderDetailService.searchOrderDetail(ntsSearchOrderDetailParam);
            if (apiResult.isSuccess() && apiResult.getResult() != null && CollectionUtils.isNotEmpty(apiResult.getResult().getPassengerInfo())) {
                passengers = apiResult.getResult().getPassengerInfo();
            }
        } catch (Exception e) {
            log.error("获取票号失败,orderNo:{}", orderNo, e);
        }
        return passengers == null ? new ArrayList<>() : passengers;
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

    private void sendSms(String orderNo, List<NtsSearchOrderDetailResultVO.Passenger> passengers) {
        if (CollectionUtils.isEmpty(passengers)) {
            return;
        }
        InternationalOrder order = internationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            return;
        }
        if (StringUtils.isBlank(order.getBackFlightNum())) {
            sendGoSms(order, passengers);
        } else {
            sendGoBackSms(order, passengers);
        }
    }

    private void sendGoSms(InternationalOrder order, List<NtsSearchOrderDetailResultVO.Passenger> passengers) {
        List<InternationalPassenger> passengerList = internationalPassengerDao.queryByOrderNo(order.getOrderNo());
        Date deptDate = DateUtil.getDate(order.getGoDeptDate(), order.getGoDeptTime());
        String deptTime = DateUtil.formatDate(deptDate.getTime()) + order.getGoDeptTime();
        String arrTime = getArriTime(order.getGoDeptDate(), order.getGoDeptTime(), order.getGoArriTime());
        String orderInfo = String.format("%s %s%s-%s%s %s-%s", order.getGoFlightNum(), order.getGoDeptAirportName(), order.getGoDeptTerminal(), order.getGoArriAirportName(), order.getGoArriTerminal(), deptTime, arrTime);

        StringBuilder passengerInfo = new StringBuilder(passengers.size() * 10);
        for (NtsSearchOrderDetailResultVO.Passenger passenger : passengers) {
            passengerInfo.append("，");
            passengerInfo.append(passenger.getName());
            passengerInfo.append(":");
            passengerInfo.append(passenger.getETicketNum());
        }
        String content = String.format(SmsConstants.TICKET_NO, orderInfo, passengerInfo.substring(1));
        smsService.sendSms(order.getContactMobile(), content, SmsSendTypeEnum.TICKET);
    }

    private void sendGoBackSms(InternationalOrder order, List<NtsSearchOrderDetailResultVO.Passenger> passengers) {
        List<InternationalPassenger> passengerList = internationalPassengerDao.queryByOrderNo(order.getOrderNo());
        Date deptDate = DateUtil.getDate(order.getGoDeptDate(), order.getGoDeptTime());
        String deptTime = DateUtil.formatDate(deptDate.getTime()) + order.getGoDeptTime();
        String arrTime = getArriTime(order.getGoDeptDate(), order.getGoDeptTime(), order.getGoArriTime());
        String goOrderInfo = String.format("%s %s%s-%s%s %s-%s", order.getGoFlightNum(), order.getGoDeptAirportName(), order.getGoDeptTerminal(), order.getGoArriAirportName(), order.getGoArriTerminal(), deptTime, arrTime);

        Date backDeptDate = DateUtil.getDate(order.getBackDeptDate(), order.getBackDeptTime());
        String backDeptTime = DateUtil.formatDate(backDeptDate.getTime()) + order.getBackDeptTime();
        String backArrTime = getArriTime(order.getBackDeptDate(), order.getBackDeptTime(), order.getBackArriTime());
        String backOrderInfo = String.format("%s %s%s-%s%s %s-%s", order.getBackFlightNum(), order.getBackDeptAirportName(), order.getBackDeptTerminal(), order.getBackArriAirportName(), order.getBackArriTerminal(), backDeptTime, backArrTime);

        for (NtsSearchOrderDetailResultVO.Passenger passenger : passengers) {
            String passengerInfo = passenger.getName() + ":" + passenger.getETicketNum();
            String content = String.format(SmsConstants.TICKET_NO_BACK, goOrderInfo, backOrderInfo, passengerInfo);
            Optional<InternationalPassenger> dbPassenger = passengerList.stream().filter(p -> p.getName().equals(passenger.getName())).findFirst();
            if (dbPassenger.isPresent() && dbPassenger.get() != null) {
                smsService.sendSms(dbPassenger.get().getMobileNo(), content, SmsSendTypeEnum.TICKET);
            }
        }
    }

    private String getArriTime(String deptDateStr, String deptTimeStr, String arriTimeStr) {
        Date deptDate = DateUtil.getDate(deptDateStr, deptTimeStr);
        Date arrDate = DateUtil.getDate(deptDateStr, arriTimeStr);
        return deptDate.getTime() < arrDate.getTime() ? DateUtil.formatDate(arrDate.getTime()) + arriTimeStr : DateUtil.formatDate(arrDate.getTime() + 1000 * 60 * 60 * 24) + arriTimeStr;
    }
}
