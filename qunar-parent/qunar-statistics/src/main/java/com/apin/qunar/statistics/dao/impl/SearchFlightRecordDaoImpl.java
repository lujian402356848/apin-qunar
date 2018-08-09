package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.SearchFlightRecordExtMapper;
import com.apin.qunar.statistics.dao.mapper.SearchFlightRecordMapper;
import com.apin.qunar.statistics.dao.model.SearchFlightRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class SearchFlightRecordDaoImpl {
    @Autowired
    private SearchFlightRecordMapper searchFlightRecordMapper;
    @Autowired
    private SearchFlightRecordExtMapper searchFlightRecordExtMapper;

    public boolean insert(SearchFlightRecord searchFlightRecord) {
        return searchFlightRecordMapper.insert(searchFlightRecord) > 0;
    }

    public int queryFlightCnt(Integer hasNational, Date startTime, Date endTime) {
        return searchFlightRecordExtMapper.queryFlightCnt(hasNational, startTime, endTime);
    }

    public boolean deleteByInsertTime(Date date) {
        return searchFlightRecordExtMapper.deleteByInsertTimeLessThan(date) > 0;
    }
}