package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.common.constant.SmsConstants;
import com.apin.qunar.basic.common.enums.SmsSendTypeEnum;
import com.apin.qunar.basic.service.SmsService;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalPassengerDaoImpl;
import com.apin.qunar.order.dao.impl.NationalReturnOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalReturnPassengerDaoImpl;
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
        try {
            if (payStatus == OrderStatusEnum.TICKET_OK.getCode()) {//状态为2说明出票成功，需要获取票号更新到数据库中
                List<SearchOrderDetailResultVO.Passenger> passengers = getPassengers(orderNo);
                String ticketNo = getTicketNo(passengers);
                if (StringUtils.isNotBlank(ticketNo)) {
                    result = nationalOrderDao.updateStatusAndTicketNo(orderNo, ticketNo, payStatus);
                    sendSms(orderNo, passengers, OrderStatusEnum.valueOf(payStatus));
                }
            } else {
                result = nationalOrderDao.updateStatus(orderNo, payStatus);
            }
            if (payStatus == OrderStatusEnum.APPLY_REFUNDMENT.getCode() || payStatus == OrderStatusEnum.WAIT_REFUNDMENT.getCode() || payStatus == OrderStatusEnum.REFUND_OK.getCode()) {//退票订单更改状态
                result = nationalReturnOrderDao.updateStatus(orderNo, payStatus);
                if (!result) {
                    SearchOrderDetailParam searchOrderDetailParam = new SearchOrderDetailParam();
                    searchOrderDetailParam.setOrderNo(orderNo);
                    ApiResult<SearchOrderDetailResultVO> apiResult = searchOrderDetailService.searchOrderDetail(searchOrderDetailParam);
                    String parentOrderNo = apiResult.getResult().getDetail().getParentOrderNo();
                    List<SearchOrderDetailResultVO.Passenger> passengers = getPassengers(orderNo);
                    result = nationalReturnOrderDao.updateStatusAndTicketNo(parentOrderNo, orderNo, payStatus, getTicketNo(passengers));
                    nationalReturnPassengerDao.updateByOrderNo(parentOrderNo, orderNo);
                }
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
        String content = "";
        switch (orderStatusEnum) {
            case TICKET_OK://出票完成
                sendTicketSms(order, passengers);
                sendTicketSms(relationOrder, passengers);
                break;
            case REFUND_OK://退款
                List<String> mobileNos = nationalPassengerDao.queryMobileNoByOrderNo(order.getOrderNo());
                if (CollectionUtils.isNotEmpty(mobileNos)) {
                    content = String.format(SmsConstants.REFUND, DateUtil.formatDate(order.getDeptDate()), order.getDeptCity(), order.getArriCity());
                    smsService.sendSms(StringUtils.join(mobileNos, ","), content, SmsSendTypeEnum.ORDER_CANCEL);
                }
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

        String orderInfo = String.format("%s%s%s-%s%s %s-%s", order.getFlightNum(), order.getDeptAirportName(), order.getDeptTerminal(), order.getArriAirportName(), order.getArriTerminal(), deptTime, arrTime);
        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
            String passengerInfo = passenger.getName() + ":" + passenger.getTicketNo();
            String content = String.format(SmsConstants.TICKET_NO, orderInfo, passengerInfo);
            smsService.sendSms(passenger.getMobileNo(), content, SmsSendTypeEnum.TICKET);
        }
    }
}