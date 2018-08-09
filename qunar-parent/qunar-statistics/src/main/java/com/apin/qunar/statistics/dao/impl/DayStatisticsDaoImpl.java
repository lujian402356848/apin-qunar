package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.DayStatisticsMapper;
import com.apin.qunar.statistics.dao.model.DayStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DayStatisticsDaoImpl {
    @Autowired
    private DayStatisticsMapper dayStatisticsMapper;

    public boolean insert(DayStatistics dayStatistics) {
        return dayStatisticsMapper.insert(dayStatistics) > 0;
    }
}