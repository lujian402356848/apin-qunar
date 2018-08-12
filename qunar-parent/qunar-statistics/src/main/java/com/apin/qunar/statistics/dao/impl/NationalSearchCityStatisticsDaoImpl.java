package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.NationalSearchCityStatisticsExtMapper;
import com.apin.qunar.statistics.dao.mapper.NationalSearchCityStatisticsMapper;
import com.apin.qunar.statistics.dao.model.NationalSearchCityStatistics;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class NationalSearchCityStatisticsDaoImpl {
    @Autowired
    private NationalSearchCityStatisticsMapper searchCityStatisticsMapper;
    @Autowired
    private NationalSearchCityStatisticsExtMapper searchCityStatisticsExtMapper;

    public Date queryMaxInsertTime() {
        return searchCityStatisticsExtMapper.queryMaxInsertTime();
    }

    public boolean insert(NationalSearchCityStatistics searchCityStatistics) {
        return searchCityStatisticsMapper.insert(searchCityStatistics) > 0;
    }

    public boolean insert(List<NationalSearchCityStatistics> searchCityStatisticsList) {
        if (CollectionUtils.isEmpty(searchCityStatisticsList)) {
            return false;
        }
        for (NationalSearchCityStatistics searchCityStatistics : searchCityStatisticsList) {
            insert(searchCityStatistics);
        }
        return true;
    }
}