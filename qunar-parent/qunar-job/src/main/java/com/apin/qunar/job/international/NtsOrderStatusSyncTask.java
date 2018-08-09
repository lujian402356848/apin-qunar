package com.apin.qunar.job.international;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.common.enums.NtsOrderStatusEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.model.InternationalOrder;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailBO;
import com.apin.qunar.order.service.international.NtsSearchOrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-31 18:04
 */
@Slf4j
@Component
public class NtsOrderStatusSyncTask {
//    @Autowired
//    private InternationalOrderDaoImpl internationalOrderDao;
//    @Autowired
//    private NtsSearchOrderDetailService searchOrderDetailService;
//
//    public void startSync() {
//        log.info("国际订单状态同步job开始执行");
//        Date lastTime = getLastTime();
//        List<Integer> statusList = Arrays.asList(NtsOrderStatusEnum.BOOK_OK.getCode(), NtsOrderStatusEnum.PAY_OK.getCode());
//        try {
//            List<InternationalOrder> orders = internationalOrderDao.queryOrderBy(statusList, lastTime, 100);
//            for (InternationalOrder order : orders) {
//                if (isConformTime(order)) {
//                    syncStatus(order);
//                    Thread.sleep(1000);//暂停1s,防止调用去哪儿接口过于频繁被封闭了
//                }
//            }
//        } catch (Exception e) {
//            log.error("同步国际订单状态异常", e);
//        }
//        log.info("国际订单状态同步job执行完毕");
//    }
//
//    private Date getLastTime() {
//        Date date = new Date();//获取当前时间
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR, -25);//当前时间减去25个小时
//        return calendar.getTime();
//    }
//
//    private boolean isConformTime(InternationalOrder order) {
//        boolean result = true;
//        if (!order.getPayStatus().equals(NtsOrderStatusEnum.PAY_OK.getCode())) {
//            return result;
//        }
//        if (StringUtils.isBlank(order.getPayTime())) {
//            return result;
//        }
//        try {
//            Date payTime = DateUtil.DEFAULT_FORMAT.parse(order.getPayTime());
//            long timeDifference = System.currentTimeMillis() - payTime.getTime();
//            int hour = (int) timeDifference / (60 * 60 * 1000);
//            result = hour > 2;//支付完成后最少2个小时才会出票
//        } catch (ParseException e) {
//            log.error("时间转换异常,order:{}", JSON.toJSON(order), e);
//            result = false;
//        }
//        return result;
//    }
//
//    private void syncStatus(InternationalOrder order) {
//        try {
//            NtsSearchOrderDetailBO searchOrderDetailBO = searchOrderDetailService.searchOrderDetailBO(order.getOrderNo());
//            if (searchOrderDetailBO.getStatus() < 0 || searchOrderDetailBO.getStatus() == order.getPayStatus()) {
//                return;
//            }
//            if (StringUtils.isNotBlank(searchOrderDetailBO.getTicket())) {
//                internationalOrderDao.updateStatusAndTicketNo(order.getOrderNo(), searchOrderDetailBO.getTicket(), searchOrderDetailBO.getStatus());
//            } else {
//                internationalOrderDao.updateStatus(order.getOrderNo(), searchOrderDetailBO.getStatus());
//            }
//        } catch (Exception e) {
//            log.error("同步国际订单状态异常,order:{}", JSON.toJSON(order), e);
//        }
//    }
}