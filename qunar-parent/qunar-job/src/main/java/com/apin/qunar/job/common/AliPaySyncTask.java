package com.apin.qunar.job.common;

import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.common.enums.AlipayStatusEnum;
import com.apin.qunar.order.dao.impl.AlipayDaoImpl;
import com.apin.qunar.order.dao.model.AliPay;
import com.apin.qunar.order.service.pay.AlipayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-31 21:41
 */
@Slf4j
@Component
public class AliPaySyncTask {
    @Autowired
    private AlipayDaoImpl alipayDao;
    @Autowired
    private AlipayService alipayService;

    /**
     * 重试支付宝超过1分钟未支付,不超过5分钟的
     */
//    @Scheduled(fixedDelay = 60 * 1000)
    private void aliPaySync() {
        log.error("支付宝支付同步job执行开始执行,时间:" + DateUtil.getCurrDate());
        Date startTime = getStartTime();
        Date endTime = getEndTime();
        try {
            List<AliPay> aliPays = alipayDao.queryBy(AlipayStatusEnum.NO_PAY.getStatus(), startTime, endTime);
            for (AliPay aliPay : aliPays) {
                log.info("订单号:{}的支付宝待处理订单开始处理", aliPay.getOrderNo());
//                updateAlipayStatus(aliPay);
            }
        } catch (Exception e) {
            log.error("支付宝支付同步job执行失败");
        }
    }

//    private void updateAlipayStatus(AliPay aliPay) {
//        QueryAlipayTradeDTO tradeDTO = alipayService.queryAlipayTrade(aliPay.getOrderNo());
//        if (tradeDTO.getAlipayStatusEnum() != AlipayStatusEnum.PAY_SUCCESS) {
//            return;
//        }
//        boolean result = alipayDao.updateAliPayInfo(aliPay.getId(), tradeDTO.getTradeNo(), AlipayStatusEnum.PAY_SUCCESS.getStatus(), DateUtil.getCurrDate());
//        if (result) {
//            alipayService.qunarOrderPay(aliPay);
//            log.info("订单号:{}的支付宝待处理订单已经同步更新，去哪儿订单支付已完成", aliPay.getOrderNo());
//        }
//    }

    private Date getStartTime() {
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -5);//当前时间减去5分钟
        return calendar.getTime();
    }

    private Date getEndTime() {
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -1);//当前时间减去1分钟
        return calendar.getTime();
    }
}
