package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.NationalSearchFlightRecordExtMapper;
import com.apin.qunar.statistics.dao.mapper.NationalSearchFlightRecordMapper;
import com.apin.qunar.statistics.dao.model.NationalSearchFlightRecord;
import com.apin.qunar.statistics.domain.SearchFlightRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class NationalSearchFlightRecordDaoImpl {
    @Autowired
    private NationalSearchFlightRecordMapper searchFlightRecordMapper;
    @Autowired
    private NationalSearchFlightRecordExtMapper searchFlightRecordExtMapper;

    public boolean insert(NationalSearchFlightRecord searchFlightRecord) {
        return searchFlightRecordMapper.insert(searchFlightRecord) > 0;
    }

    public List<String> queryAccountByInsertTime(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            return new ArrayList<>();
        }
        return searchFlightRecordExtMapper.queryAccountByInsertTime(startTime, endTime);
    }

    public int queryFlightCntByMerchantNoAndInsertTime(String account, Date startTime, Date endTime) {
        return searchFlightRecordExtMapper.queryFlightCntBy(account, startTime, endTime);
    }

    public List<SearchFlightRecordDTO> queryDeptCityTop20By(String merchantNo, Date startTime, Date endTime) {
        return searchFlightRecordExtMapper.queryDeptCityTop20By(merchantNo, startTime, endTime);
    }

    public List<SearchFlightRecordDTO> queryArriCityTop20By(String merchantNo, Date startTime, Date endTime) {
        return searchFlightRecordExtMapper.queryArriCityTop20By(merchantNo, startTime, endTime);
    }

    public boolean deleteByInsertTime(Date date) {
        return searchFlightRecordExtMapper.deleteByInsertTimeLessThan(date) > 0;
    }
}