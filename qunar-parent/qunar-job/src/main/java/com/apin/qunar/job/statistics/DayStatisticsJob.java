package com.apin.qunar.job.statistics;

import com.apin.qunar.basic.dao.impl.MerchantDaoImpl;
import com.apin.qunar.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Slf4j
@Component
public class DayStatisticsJob {
    @Autowired
    private MerchantDaoImpl merchantDao;

    /**
     * 商户统计job启动
     */
    @Scheduled(fixedDelay = 60 * 1000)
    private void start() {
        log.error("统计job开始执行,时间:" + DateUtil.getCurrDate());
        Date startTime = getStartTime();
        Date endTime = getEndTime();
        try {

        } catch (Exception e) {
            log.error("统计job执行失败");
        }
    }

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
