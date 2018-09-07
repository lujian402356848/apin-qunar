package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.InternationalSearchCityStatisticsExtMapper;
import com.apin.qunar.statistics.dao.mapper.InternationalSearchCityStatisticsMapper;
import com.apin.qunar.statistics.dao.model.InternationalSearchCityStatistics;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class InternationalSearchCityStatisticsDaoImpl {
    @Autowired
    private InternationalSearchCityStatisticsMapper searchCityStatisticsMapper;
    @Autowired
    private InternationalSearchCityStatisticsExtMapper searchCityStatisticsExtMapper;

    public Date queryMaxInsertTime() {
        return searchCityStatisticsExtMapper.queryMaxInsertTime();
    }

    public boolean insert(InternationalSearchCityStatistics searchCityStatistics) {
        return searchCityStatisticsMapper.insert(searchCityStatistics) > 0;
    }

    public boolean insert(List<InternationalSearchCityStatistics> searchCityStatisticsList) {
        if (CollectionUtils.isEmpty(searchCityStatisticsList)) {
            return false;
        }
        for (InternationalSearchCityStatistics searchCityStatistics : searchCityStatisticsList) {
            insert(searchCityStatistics);
        }
        return true;
    }
}