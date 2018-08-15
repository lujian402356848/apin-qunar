package com.apin.qunar.job.statistics;

import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.statistics.common.enums.GoBackTypeEnum;
import com.apin.qunar.statistics.dao.impl.InternationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.impl.NationalSearchCityStatisticsDaoImpl;
import com.apin.qunar.statistics.dao.impl.NationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.model.NationalSearchCityStatistics;
import com.apin.qunar.statistics.domain.SearchFlightRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class SearchCityStatisticsJob {
    @Autowired
    private NationalSearchCityStatisticsDaoImpl nationalSearchCityStatisticsDao;
    @Autowired
    private NationalSearchFlightRecordDaoImpl nationalSearchFlightRecordDao;
    @Autowired
    private InternationalSearchFlightRecordDaoImpl internationalSearchFlightRecordDao;

    /**
     * 国内城市查询统计job启动
     */
    @Scheduled(cron = "0 0 1 * * *")
    private void start() {
        log.info("国内城市查询统计job开始执行,时间:" + DateUtil.getCurrDate());
        if (isExecute()) {
            return;
        }
        try {
            statistics();
        } catch (Exception e) {
            log.error("国内城市查询统计job执行失败", e);
        }
    }

    private void statistics() {
        Date startTime = getStartTime();
        Date endTime = getEndTime();
        List<String> merchantNos = internationalSearchFlightRecordDao.queryMerchantNoByInsertTime(startTime, endTime);
        if (CollectionUtils.isEmpty(merchantNos)) {
            return;
        }
        List<SearchFlightRecordDTO> searchFlightRecordDTOs = null;
        List<NationalSearchCityStatistics> searchCityStatistics = null;
        for (String merchantNo : merchantNos) {
            searchFlightRecordDTOs = nationalSearchFlightRecordDao.queryDeptCityTop20By(merchantNo, startTime, endTime);
            searchCityStatistics = buildSearchCityStatisticsList(searchFlightRecordDTOs, GoBackTypeEnum.DEPT);
            nationalSearchCityStatisticsDao.insert(searchCityStatistics);

            searchFlightRecordDTOs = nationalSearchFlightRecordDao.queryArriCityTop20By(merchantNo, startTime, endTime);
            searchCityStatistics = buildSearchCityStatisticsList(searchFlightRecordDTOs, GoBackTypeEnum.ARRI);
            nationalSearchCityStatisticsDao.insert(searchCityStatistics);
        }
    }

    private List<NationalSearchCityStatistics> buildSearchCityStatisticsList(List<SearchFlightRecordDTO> searchFlightRecordDTOs, GoBackTypeEnum goBackTypeEnum) {
        List<NationalSearchCityStatistics> searchCityStatisticsList = new ArrayList<>();
        if (CollectionUtils.isEmpty(searchFlightRecordDTOs)) {
            return searchCityStatisticsList;
        }
        for (SearchFlightRecordDTO flightRecordDTO : searchFlightRecordDTOs) {
            searchCityStatisticsList.add(buildSearchCityStatistics(flightRecordDTO, goBackTypeEnum));
        }
        return searchCityStatisticsList;
    }

    private NationalSearchCityStatistics buildSearchCityStatistics(SearchFlightRecordDTO flightRecordDTO, GoBackTypeEnum goBackTypeEnum) {
        NationalSearchCityStatistics searchCityStatistics = new NationalSearchCityStatistics();
        searchCityStatistics.setMerchantNo(flightRecordDTO.getMerchantNo());
        searchCityStatistics.setGoBackType(goBackTypeEnum.getCode());
        searchCityStatistics.setCity(flightRecordDTO.getCity());
        searchCityStatistics.setSearchCnt(flightRecordDTO.getSearchCnt());
        return searchCityStatistics;
    }

    private boolean isExecute() {
        Date maxDate = nationalSearchCityStatisticsDao.queryMaxInsertTime();
        if (maxDate == null) {
            return false;
        }
        String currDate = DateUtil.format(new Date(), DateUtil.DEFAULT_DATE_DAYPATTERN);
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
