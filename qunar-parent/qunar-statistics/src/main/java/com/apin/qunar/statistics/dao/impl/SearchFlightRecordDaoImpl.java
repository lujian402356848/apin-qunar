package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.SearchFlightRecordMapper;
import com.apin.qunar.statistics.dao.model.SearchFlightRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchFlightRecordDaoImpl {
    @Autowired
    private SearchFlightRecordMapper searchFlightRecordMapper;

    public boolean insert(SearchFlightRecord searchFlightRecord) {
        return searchFlightRecordMapper.insert(searchFlightRecord) > 0;
    }
}