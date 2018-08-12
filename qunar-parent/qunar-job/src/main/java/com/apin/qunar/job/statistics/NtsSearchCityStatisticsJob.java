package com.apin.qunar.job.statistics;

import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.statistics.common.enums.GoBackTypeEnum;
import com.apin.qunar.statistics.dao.impl.InternationalSearchCityStatisticsDaoImpl;
import com.apin.qunar.statistics.dao.impl.InternationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.model.InternationalSearchCityStatistics;
import com.apin.qunar.statistics.domain.SearchFlightRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class NtsSearchCityStatisticsJob {
    @Autowired
    private InternationalSearchCityStatisticsDaoImpl internationalSearchCityStatisticsDao;
    @Autowired
    private InternationalSearchFlightRecordDaoImpl internationalSearchFlightRecordDao;

    /**
     * 国际城市查询统计job启动
     */
//    @Scheduled(fixedDelay = 60 * 60 * 1000)
    private void start() {
        log.error("国际城市查询统计job开始执行,时间:" + DateUtil.getCurrDate());
        if (!isExecute()) {
            return;
        }
        try {
            statistics();
        } catch (Exception e) {
            log.error("国际城市查询统计job执行失败", e);
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
        List<InternationalSearchCityStatistics> searchCityStatistics = null;
        for (String merchantNo : merchantNos) {
            searchFlightRecordDTOs = internationalSearchFlightRecordDao.queryDeptCityTop20By(merchantNo, startTime, endTime);
            searchCityStatistics = buildSearchCityStatisticsList(searchFlightRecordDTOs, GoBackTypeEnum.DEPT);
            internationalSearchCityStatisticsDao.insert(searchCityStatistics);

            searchFlightRecordDTOs = internationalSearchFlightRecordDao.queryArriCityTop20By(merchantNo, startTime, endTime);
            searchCityStatistics = buildSearchCityStatisticsList(searchFlightRecordDTOs, GoBackTypeEnum.ARRI);
            internationalSearchCityStatisticsDao.insert(searchCityStatistics);
        }
    }

    private List<InternationalSearchCityStatistics> buildSearchCityStatisticsList(List<SearchFlightRecordDTO> searchFlightRecordDTOs, GoBackTypeEnum goBackTypeEnum) {
        List<InternationalSearchCityStatistics> searchCityStatisticsList = new ArrayList<>();
        if (CollectionUtils.isEmpty(searchFlightRecordDTOs)) {
            return searchCityStatisticsList;
        }
        for (SearchFlightRecordDTO flightRecordDTO : searchFlightRecordDTOs) {
            searchCityStatisticsList.add(buildSearchCityStatistics(flightRecordDTO, goBackTypeEnum));
        }
        return searchCityStatisticsList;
    }

    private InternationalSearchCityStatistics buildSearchCityStatistics(SearchFlightRecordDTO flightRecordDTO, GoBackTypeEnum goBackTypeEnum) {
        InternationalSearchCityStatistics searchCityStatistics = new InternationalSearchCityStatistics();
        searchCityStatistics.setMerchantNo(flightRecordDTO.getMerchantNo());
        searchCityStatistics.setGoBackType(goBackTypeEnum.getCode());
        searchCityStatistics.setCity(flightRecordDTO.getCity());
        searchCityStatistics.setSearchCnt(flightRecordDTO.getSearchCnt());
        return searchCityStatistics;
    }

    private boolean isExecute() {
        Date maxDate = internationalSearchCityStatisticsDao.queryMaxInsertTime();
        if (maxDate == null) {
            return true;
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
