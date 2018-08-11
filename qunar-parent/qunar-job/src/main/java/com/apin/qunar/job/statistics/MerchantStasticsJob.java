package com.apin.qunar.job.statistics;

import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.common.enums.OrderStatusEnum;
import com.apin.qunar.order.dao.impl.InternationalOrderDaoImpl;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.statistics.dao.impl.DayMerchantStatisticsDaoImpl;
import com.apin.qunar.statistics.dao.impl.DayStatisticsDaoImpl;
import com.apin.qunar.statistics.dao.impl.InternationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.impl.NationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.model.DayMerchantStatistics;
import com.apin.qunar.statistics.dao.model.DayStatistics;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class MerchantStasticsJob {
    @Autowired
    private DayStatisticsDaoImpl dayStatisticsDao;
    @Autowired
    private DayMerchantStatisticsDaoImpl dayMerchantStatisticsDao;
    @Autowired
    private NationalSearchFlightRecordDaoImpl nationalSearchFlightRecordDao;
    @Autowired
    private InternationalSearchFlightRecordDaoImpl internationalSearchFlightRecordDao;
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private InternationalOrderDaoImpl internationalOrderDao;

    /**
     * 商户统计job启动
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    private void start() {
        log.error("商户统计job开始执行,时间:" + DateUtil.getCurrDate());
        if (!isExecute()) {
            return;
        }
        try {
            statstics();
        } catch (Exception e) {
            log.error("商户统计job执行失败", e);
        }
    }

    private void statstics() {
        List<Integer> orderStatus = Arrays.asList(OrderStatusEnum.TICKET_OK.getCode(), OrderStatusEnum.PAY_OK.getCode(), OrderStatusEnum.TICKET_LOCK.getCode());
        Date startTime = getStartTime();
        Date endTime = getEndTime();
        List<String> merchantNos = internationalSearchFlightRecordDao.queryMerchantNoByInsertTime(startTime, endTime);
        if (CollectionUtils.isEmpty(merchantNos)) {
            return;
        }
        int flightCnt = 0;
        int ntsFlightCnt = 0;
        int totalOrderCnt = 0;
        int detalTotalAmount = 0;
        for (String merchantNo : merchantNos) {
            int merFlightCnt = internationalSearchFlightRecordDao.queryFlightCntByMerchantNoAndInsertTime(merchantNo, startTime, endTime);
            int merNtsFlightCnt = nationalSearchFlightRecordDao.queryFlightCnt(merchantNo, startTime, endTime);
            int merOrderCnt = nationalOrderDao.queryCntBy(merchantNo, orderStatus, startTime, endTime);
            int merDealTotalAmount = nationalOrderDao.queryTotalAmountBy(merchantNo, orderStatus, startTime, endTime);
            DayMerchantStatistics merchantStatistics = buildDayMerchantStatistics(merchantNo, 1, merFlightCnt, merNtsFlightCnt, merOrderCnt, merDealTotalAmount);
            dayMerchantStatisticsDao.insert(merchantStatistics);
        }
        DayStatistics dayStatistics = buildDayStatistics(1, 1, flightCnt, ntsFlightCnt, totalOrderCnt, detalTotalAmount);
        dayStatisticsDao.insert(dayStatistics);
    }

    private DayMerchantStatistics buildDayMerchantStatistics(String merchantNo, int pv, int flightCnt, int nstFlightCnt, int totalOrderCtn, int dealTotalAmount) {
        DayMerchantStatistics dayMerchantStatistics = new DayMerchantStatistics();
        dayMerchantStatistics.setMerchantNo(merchantNo);
        dayMerchantStatistics.setMerchantPv(pv);
        dayMerchantStatistics.setSearchNationalFlightCnt(flightCnt);
        dayMerchantStatistics.setSearchInternationalFlightCnt(nstFlightCnt);
        dayMerchantStatistics.setDealOrderCnt(totalOrderCtn);
        dayMerchantStatistics.setDealTotalAmount(dealTotalAmount);
        return dayMerchantStatistics;
    }

    private DayStatistics buildDayStatistics(int pv, int uv, int flightCnt, int nstFlightCnt, int totalOrderCtn, int dealTotalAmount) {
        DayStatistics dayStatistics = new DayStatistics();
        dayStatistics.setTotalPv(pv);
        dayStatistics.setTotalUv(uv);
        dayStatistics.setSearchNationalFlightCnt(flightCnt);
        dayStatistics.setSearchInternationalFlightCnt(nstFlightCnt);
        dayStatistics.setDealOrderCnt(totalOrderCtn);
        dayStatistics.setDealTotalAmount(totalOrderCtn);
        return dayStatistics;
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
