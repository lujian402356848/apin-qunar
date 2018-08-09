package com.apin.qunar.job.statistics;

import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.statistics.dao.impl.DayMerchantStatisticsDaoImpl;
import com.apin.qunar.statistics.dao.impl.SearchFlightRecordDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class DayMerchantStatisticsJob {
    @Autowired
    private DayMerchantStatisticsDaoImpl dayMerchantStatisticsDao;
    @Autowired
    private SearchFlightRecordDaoImpl searchFlightRecordDao;

    /**
     * 商户统计job启动
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    private void start() {
        log.error("商户按天统计job开始执行,时间:" + DateUtil.getCurrDate());
        if (!isExecute()) {
            return;
        }

        try {
        } catch (Exception e) {
            log.error("商户按天统计job执行失败");
        }
    }

    private void statstics() {
        Date startTime = getStartTime();
        Date endTime = getEndTime();
        List<String> merchantNos = searchFlightRecordDao.queryMerchantNoByInsertTime(startTime, endTime);
        if (CollectionUtils.isEmpty(merchantNos)) {
            return;
        }
        for (String merchantNo : merchantNos) {
//            searchFlightRecordDao.queryFlightCnt()
        }
    }

    private boolean isExecute() {
        Date maxDate = dayMerchantStatisticsDao.queryMaxInsertTime();
        if (maxDate == null) {
            return true;
        }
        String currDate = DateUtil.getCurrDate();
        String maxDateFormat = DateUtil.format(maxDate, DateUtil.DEFAULT_DATE_DAYPATTERN);
        return currDate.equalsIgnoreCase(maxDateFormat);
    }

    private Date getStartTime() {
        Date date = DateUtil.getDateByYYYYMMDD(DateUtil.getCurrDate());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    private Date getEndTime() {
        return DateUtil.getDateByYYYYMMDD(DateUtil.getCurrDate());
    }
}
