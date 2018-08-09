package com.apin.qunar.job.national;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.dao.model.NationalOrder;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailResultVO;
import com.apin.qunar.order.service.national.SearchOrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-31 18:07
 */
@Slf4j
@Component
public class OrderStatusSyncTask {
//    @Autowired
//    private NationalOrderDaoImpl nationalOrderDao;
//    @Autowired
//    private SearchOrderDetailService searchOrderDetailService;
//
//    public void startSync() {
//        log.info("国内订单状态同步job开始执行");
//        syncUnAliPay();
//        syncAlipaySuccess();
//        log.info("国内订单状态同步job执行完毕");
//    }
//
//    private void syncUnAliPay() {
//        Date startTime = getStartTime();
//        Date endTime = getEndTime();
////        List<Integer> statusList = Arrays.asList(NtsOrderStatusEnum.BOOK_OK.getCode(), NtsOrderStatusEnum.PAY_OK.getCode());
//        try {
//            List<NationalOrder> orders = nationalOrderDao.queryOrderBy(OrderStatusEnum.PAY_OK.getCode(), startTime, endTime);
//            for (NationalOrder order : orders) {
//                syncStatus(order);
//                Thread.sleep(1000);//暂停1s,防止调用去哪儿接口过于频繁被封闭了
//            }
//        } catch (Exception e) {
//            log.error("国内订单状态异常", e);
//        }
//    }
//
//    private void syncAlipaySuccess() {
//        log.info("国内订单状态同步job开始执行");
//        Date startTime = getStartTime();
//        Date endTime = getEndTime();
////        List<Integer> statusList = Arrays.asList(NtsOrderStatusEnum.BOOK_OK.getCode(), NtsOrderStatusEnum.PAY_OK.getCode());
//        try {
//            List<NationalOrder> orders = nationalOrderDao.queryOrderBy(OrderStatusEnum.PAY_OK.getCode(), startTime, endTime);
//            for (NationalOrder order : orders) {
//                syncStatus(order);
//                Thread.sleep(1000);//暂停1s,防止调用去哪儿接口过于频繁被封闭了
//            }
//        } catch (Exception e) {
//            log.error("国内订单状态异常", e);
//        }
//        log.info("国内订单状态同步job执行完毕");
//    }
//
//    private Date getStartTime() {
//        Date date = new Date();//获取当前时间
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR, -15);//当前时间减去25个小时
//        return calendar.getTime();
//    }
//
//    private Date getEndTime() {
//        Date date = new Date();//获取当前时间
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR, -1);//当前时间减去25个小时
//        return calendar.getTime();
//    }
//
//    private void syncStatus(NationalOrder order) {
//        SearchOrderDetailParam detailParam = new SearchOrderDetailParam();
//        detailParam.setOrderNo(order.getOrderNo());
//        try {
//            ApiResult<SearchOrderDetailResultVO> searchOrderDetailResultVO = searchOrderDetailService.searchOrderDetail(detailParam);
//            if (searchOrderDetailResultVO == null || searchOrderDetailResultVO.getResult() == null) {
//                return;
//            }
//            SearchOrderDetailResultVO.OrderDetail orderDetail = searchOrderDetailResultVO.getResult().getDetail();
//            if (orderDetail == null) {
//                return;
//            }
//            String status = orderDetail.getStatus();
//            if (status.equals("支付成功，等待出票")) {
//                return;
//            }
//            if (status.equals(OrderStatusEnum.TICKET_OK.getDesc())) {
//                String ticketNo = getTicketNo(searchOrderDetailResultVO.getResult().getPassengers());
//                if (StringUtils.isNotBlank(ticketNo)) {
//                    nationalOrderDao.updateStatusAndTicketNo(order.getOrderNo(), ticketNo, OrderStatusEnum.TICKET_OK.getCode());
//                }
//            } else if (status.equals("出票中")) {
//                nationalOrderDao.updateStatus(order.getOrderNo(), OrderStatusEnum.TICKET_LOCK.getCode());
//            } else {
//                if (status.equals("订单取消")) {
//                    OrderStatusEnum orderStatus = OrderStatusEnum.CANCEL_OK;
//                    nationalOrderDao.updateStatus(order.getOrderNo(), orderStatus.getCode());
//                }
//
//            }
//        } catch (Exception e) {
//            log.error("同步国际订单状态异常,order:{}", JSON.toJSON(order), e);
//        }
//    }
//
//    private String getTicketNo(List<SearchOrderDetailResultVO.Passenger> passengers) {
//        StringBuilder ticketNoStr = new StringBuilder(100);
//        for (SearchOrderDetailResultVO.Passenger passenger : passengers) {
//            if (StringUtils.isBlank(passenger.getTicketNo())) {
//                continue;
//            }
//            ticketNoStr.append(",");
//            ticketNoStr.append(passenger.getName());
//            ticketNoStr.append("/");
//            ticketNoStr.append(passenger.getTicketNo());
//        }
//        return ticketNoStr.length() < 1 ? "" : ticketNoStr.substring(1);
//    }
}