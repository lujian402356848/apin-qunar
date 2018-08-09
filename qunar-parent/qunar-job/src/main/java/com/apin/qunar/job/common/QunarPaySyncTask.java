package com.apin.qunar.job.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @outhor lujian
 * @create 2018-07-31 19:25
 */
@Slf4j
@Component
public class QunarPaySyncTask {
//    @Autowired
//    private AlipayDaoImpl alipayDao;
//    @Autowired
//    private AlipayService alipayService;
//
//    private static final List<Integer> qunarPayStatus = Arrays.asList(QunarPayStatusEnum.NO_PAY.getStatus(), QunarPayStatusEnum.PAY_FAIL.getStatus());//0:待支付,1:支付失败
//
//    /**
//     * 重试支付宝支付成功超过1分钟,不超过5分钟，但是去哪儿状态为未支付或者支付失败的
//     */
//    @Scheduled(fixedDelay = 60 * 1000)
//    private void qunarPaySync() {
//        log.info("去哪儿支付同步job开始执行,时间:" + DateUtil.getCurrDate());
//        Date startTime = getStartTime();
//        Date endTime = getEndTime();
//        try {
//            List<Alipay> alipays = new ArrayList<>(); //alipayDao.queryBy(AlipayStatusEnum.PAY_SUCCESS.getStatus(), qunarPayStatus, startTime, endTime);
//            for (Alipay alipay : alipays) {
//                log.info("订单号:{}的去哪儿待处理订单开始同步", alipay.getOrderNo());
//                alipayService.qunarOrderPay(alipay);
//                log.info("订单号:{}的去哪儿待处理订单已经同步更新", alipay.getOrderNo());
//            }
//        } catch (Exception e) {
//            log.error("去哪儿支付同步job执行失败");
//        }
//    }
//
//    private Date getStartTime() {
//        Date date = new Date();//获取当前时间
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR, 13);
//        calendar.add(Calendar.MINUTE, -5);//当前时间减去5分钟
//        return calendar.getTime();
//    }
//
//    private Date getEndTime() {
//        Date date = new Date();//获取当前时间
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR, 13);
//        calendar.add(Calendar.MINUTE, -1);//当前时间减去1分钟
//        return calendar.getTime();
//    }
}
