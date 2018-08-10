package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.InternationalSearchFlightRecordExtMapper;
import com.apin.qunar.statistics.dao.mapper.InternationalSearchFlightRecordMapper;
import com.apin.qunar.statistics.dao.model.InternationalSearchFlightRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class InternationalSearchFlightRecordDaoImpl {
    @Autowired
    private InternationalSearchFlightRecordMapper searchFlightRecordMapper;
    @Autowired
    private InternationalSearchFlightRecordExtMapper searchFlightRecordExtMapper;

    public boolean insert(InternationalSearchFlightRecord searchFlightRecord) {
        return searchFlightRecordMapper.insert(searchFlightRecord) > 0;
    }

    public List<String> queryMerchantNoByInsertTime(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            return new ArrayList<>();
        }
        return searchFlightRecordExtMapper.queryMerchantNoByInsertTime(startTime, endTime);
    }

    public int queryFlightCntByMerchantNoAndInsertTime(String merchantNo, Date startTime, Date endTime) {
        return searchFlightRecordExtMapper.queryFlightCntBy(merchantNo, startTime, endTime);
    }

    public boolean deleteByInsertTime(Date date) {
        return searchFlightRecordExtMapper.deleteByInsertTimeLessThan(date) > 0;
    }
}