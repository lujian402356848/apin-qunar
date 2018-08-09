package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.DayMerchantStatisticsExtMapper;
import com.apin.qunar.statistics.dao.mapper.DayMerchantStatisticsMapper;
import com.apin.qunar.statistics.dao.model.DayMerchantStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class DayMerchantStatisticsDaoImpl {
    @Autowired
    private DayMerchantStatisticsMapper dayMerchantStatisticsMapper;
    @Autowired
    private DayMerchantStatisticsExtMapper dayMerchantStatisticsExtMapper;

    public boolean insert(DayMerchantStatistics dayMerchantStatistics) {
        return dayMerchantStatisticsMapper.insert(dayMerchantStatistics) > 0;
    }

    public Date queryMaxInsertTime() {
        return dayMerchantStatisticsExtMapper.queryMaxInsertTime();
    }
}
