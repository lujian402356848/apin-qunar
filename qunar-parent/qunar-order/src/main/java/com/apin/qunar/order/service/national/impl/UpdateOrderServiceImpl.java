package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.AccountTypeEnum;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.dao.impl.UserDaoImpl;
import com.apin.qunar.basic.dao.model.User;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.*;
import com.apin.qunar.order.dao.model.NationalChangeOrder;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailResultVO;
import com.apin.qunar.order.service.national.UpdateOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-27 16:36
 */
@Slf4j
@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {
    private static final List<OrderStatusEnum> sendSmsOrderStatus = Arrays.asList(OrderStatusEnum.TICKET_OK, OrderStatusEnum.REFUND_OK);

    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private NationalPassengerDaoImpl nationalPassengerDao;
    @Autowired
    private SearchOrderDetailServiceImpl searchOrderDetailService;
    @Autowired
    private NationalReturnPassengerDaoImpl nationalReturnPassengerDao;
    @Autowired
    private NationalReturnOrderDaoImpl nationalReturnOrderDao;
    @Autowired
    private SmsService smsService;
    @Autowired
    private NationalChangeOrderDaoImpl nationalChangeOrderDao;
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public boolean updatePayInfo(final String orderNo, final String payId, final int orderStatus, final String payTime) {
        boolean result = false;
        try {
            result = nationalOrderDao.updatePayInfo(orderNo, payId, orderStatus, payTime);
        } catch (Exception e) {
            log.error("更新订单支付信息异常,orderNo:{},payId:{},payStatus:{},payTime:{},payErrorMsg:{}", orderNo, payId, orderStatus, payTime, e);
        }
        return result;
    }

    @Override
    public boolean updateStatus(final String orderNo, final int payStatus) {
        boolean result = false;
        if (StringUtils.isBlank(orderNo)) {
            return result;
        }
        OrderStatusEnum orderStatusEnum = OrderStatusEnum.valueOf(payStatus);
        if (orderStatusEnum == null) {
            log.warn("回调的订单{}状态不正确,status:{}", orderNo, payStatus);
            return result;
        }
        String ticketNo = "";
        List<SearchOrderDetailResultVO.Passenger> passengers = null;
        try {
            switch (orderStatusEnum) {
                case TICKET_OK://出票成功状态
                    passengers = getPassengers(orderNo);
                    ticketNo = getTicketNo(passengers);
                    if (StringUtils.isNotBlank(ticketNo)) {
                        result = nationalOrderDao.updateStatusAndTicketNo(orderNo, ticketNo, payStatus);
                        sendSms(orderNo, passengers, OrderStatusEnum.valueOf(payStatus));
                    }
                    break;
                case APPLY_REFUNDMENT://退款状态
                case WAIT_REFUNDMENT:
                case REFUND_OK:
                    result = nationalReturnOrderDao.updateStatus(orderNo, payStatus);
                    if (!result) {
                        SearchOrderDetailParam searchOrderDetailParam = new SearchOrderDetailParam();
                        searchOrderDetailParam.setOrderNo(orderNo);
                        ApiResult<SearchOrderDetailResultVO> apiResult = searchOrderDetailService.searchOrderDetail(searchOrderDetailParam);
                        String parentOrderNo = apiResult.getResult().getDetail().getParentOrderNo();
                        passengers = getPassengers(orderNo);
                        ticketNo = getTicketNo(passengers);
                        nationalOrderDao.updateStatus(orderNo, payStatus);
                        result = nationalReturnOrderDao.updateStatusAndTicketNo(parentOrderNo, orderNo, payStatus, ticketNo);
                        nationalReturnPassengerDao.updateByOrderNo(parentOrderNo, orderNo);
                    }
                    passengers = getPassengers(orderNo);
                    sendSms(orderNo, passengers, OrderStatusEnum.valueOf(payStatus));
                    break;
                case APPLY_CHANGE://改签中状态
                    nationalOrderDao.updateStatus(orderNo, payStatus);
                    nationalChangeOrderDao.updateStatus(orderNo, payStatus);
                    break;
                case CHANGE_OK://改签成功状态
                    passengers = getPassengers(orderNo);
                    ticketNo = getTicketNo(passengers);
                    if (StringUtils.isNotBlank(ticketNo)) {
                        result = nationalChangeOrderDao.updateStatusAndTicketNo(orderNo, payStatus, ticketNo);
                    }
                    nationalOrderDao.updateStatus(orderNo, payStatus);
                    sendSms(orderNo, passengers, OrderStatusEnum.valueOf(payStatus));
                    break;
                default://默认修改订单状态
                    nationalOrderDao.updateStatus(orderNo, payStatus);
                    break;
            }
        } catch (Exception e) {
            log.error("更新订单状态失败,orderNo:{},payStatus:{}", orderNo, payStatus, e);
        }
        return result;
    }

    private List<SearchOrderDetailResultVO.Passenger> getPassengers(final String orderNo) {
        List<SearchOrderDetailResultVO.Passenger> passengers = null;
        SearchOrderDetailParam searchOrderDetailParam = new SearchOrderDetailParam();
        searchOrderDetailParam.setOrderNo(orderNo);
        try {
            ApiResult<SearchOrderDetailResultVO> apiResult = searchOrderDetailService.searchOrderDetail(searchOrderDetailParam);
            if (apiResult.isSuccess() && apiResult.getResult() != null) {
                passengers = apiResult.getResult().getPassengers();
            }
        } catch (Exception e) {
            log.error("获取订单明细失败,orderNo:{}", orderNo, e);
        }
        return passengers == null ? new ArrayList<>() : passengers;
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

    public void sendSms(String orderNo, List<SearchOrderDetailResultVO.Passenger> passengers, OrderStatusEnum orderStatusEnum) {
        if (!sendSmsOrderStatus.contains(orderStatusEnum)) {
            return;
        }
        NationalOrder order = nationalOrderDao.queryByOrderNo(orderNo);
        if (order == null) {
            return;
        }
        NationalOrder relationOrder = null;
        if (StringUtils.isNotBlank(order.getOrderRelationNo())) {
            nationalOrderDao.queryRelationOrderBy(order.getId(), order.getOrderNo(), order.getOrderRelationNo());
        }
        switch (orderStatusEnum) {
            case TICKET_OK://出票完成
                sendTicketSms(order, passengers);
                sendTicketSms(relationOrder, passengers);
                break;
            case REFUND_OK://退款
                sendReturnSms(order, passengers);
                break;
            case CHANGE_OK://改签成功
                sendChangeSms(order, passengers);
                break;
        }
    }

    private void sendTicketSms(NationalOrder order, List<SearchOrderDetailResultVO.Passenger> passengers) {
        if (order == null || CollectionUtils.isEmpty(passengers)) {
            return;
        }
        Date deptDate = DateUtil.getDate(order.getDeptDate(), order.getDeptTime());
        Date arrDate = DateUtil.getDate(order.getDeptDate(), order.getArriTime());
        String deptTime = DateUtil.formatDate(deptDate.getTime()) + order.getDeptTime();
        String arrTime = deptDate.getTime() < arrDate.getTime() ? DateUtil.formatDate(arrDate.getTime()) + order.getArriTime() : DateUtil.formatDate(arrDate.getTime() + 1000 * 60 * 60 * 24) + order.getArriTime();
        StringBuilder passengerInfo = new StringBuilder(passengers.size() * 10);
        String orderInfo = String.format("%s%s%s-%s%s %s-%s", order.getFlightNum(), order.getDeptAirportName(), order.getDeptTerminal(), order.getArriAirportName(), order.getArriTerminal(), deptTime, arrTime);
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            passengerInfo.append("，");
            passengerInfo.append(passenger.getName());
            passengerInfo.append(":");
            passengerInfo.append(passenger.getTicketNo());

            String passengerContent = passenger.getName() + ":" + passenger.getTicketNo();
            String content = String.format(SmsConstants.TICKET_NO, orderInfo, passengerContent);
            smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.TICKET);
        }
        User user = userDao.queryByAccount(order.getOperator());
        if (user != null && user.getAccountType() == AccountTypeEnum.MERCHANT.getCode()) {//如果是商户下的订单，商户也会
            String content = String.format(SmsConstants.TICKET_NO, orderInfo, passengerInfo.substring(1));
            smsService.sendSms(order.getOperator(), content, SmsSendTypeEnum.TICKET);
        }
    }

    private void sendReturnSms(NationalOrder order, List<SearchOrderDetailResultVO.Passenger> passengers) {
        String content = "";
        StringBuilder passengerInfo = new StringBuilder();
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            passengerInfo.append("，");
            passengerInfo.append(passenger.getName());
            passengerInfo.append(":");
            passengerInfo.append(passenger.getTicketNo());

            String passengerContent = passenger.getName() + ":" + passenger.getTicketNo();
            content = String.format(SmsConstants.RETURN, passengerContent, order.getDeptDate(), order.getDeptTime(), order.getDeptCity(), order.getArriCity(), order.getOrderNo());
            smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.RETURN);
        }
        User user = userDao.queryByAccount(order.getOperator());
        if (user != null && user.getAccountType() == AccountTypeEnum.MERCHANT.getCode()) {//如果是商户下的订单，商户也会
            content = String.format(SmsConstants.RETURN, passengerInfo.substring(1), order.getDeptDate(), order.getDeptTime(), order.getDeptCity(), order.getArriCity(), order.getOrderNo());
            smsService.sendSms(order.getOperator(), content, SmsSendTypeEnum.TICKET);
        }
    }

    private void sendChangeSms(NationalOrder order, List<SearchOrderDetailResultVO.Passenger> passengers) {
        String content = "";
        String targetFlightInfo = "";
        StringBuilder passengerInfo = new StringBuilder();
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            passengerInfo.append("，");
            passengerInfo.append(passenger.getName());
            passengerInfo.append(":");
            passengerInfo.append(passenger.getTicketNo());

            String passengerContent = passenger.getName() + ":" + passenger.getTicketNo();
            NationalChangeOrder changeOrder = nationalChangeOrderDao.queryByParentOrderNo(order.getOrderNo());
            if (changeOrder != null) {
                targetFlightInfo = String.format("新订单【%s】%s %s从%s到%s", changeOrder.getOrderNo(), changeOrder.getDeptDate(), changeOrder.getDeptTime(), changeOrder.getDeptCity(), changeOrder.getArriCity());
                content = String.format(SmsConstants.QUNAR_CHANGE, passengerContent, order.getDeptDate(), order.getDeptTime(), order.getDeptCity(), order.getArriCity(), order.getOrderNo(), targetFlightInfo);
                smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.CHANGE);
            }

        }
    }
}