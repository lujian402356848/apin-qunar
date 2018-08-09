package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.InternationalSearchFlightRecordExtMapper;
import com.apin.qunar.statistics.dao.mapper.InternationalSearchFlightRecordMapper;
import com.apin.qunar.statistics.dao.model.InternationalSearchFlightRecord;
import com.apin.qunar.statistics.dao.model.InternationalSearchFlightRecordExample;
import org.apache.commons.lang3.StringUtils;
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
        return searchFlightRecordExtMapper.queryAllMerchantNo(startTime, endTime);
    }

    public int queryFlightCnt(String merchantNo, Date startTime, Date endTime) {
        InternationalSearchFlightRecordExample example = new InternationalSearchFlightRecordExample();
        InternationalSearchFlightRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (startTime != null) {
            criteria.andInsertTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null) {
            criteria.andInsertTimeLessThan(endTime);
        }
        return searchFlightRecordMapper.countByExample(example);
    }

    public boolean deleteByInsertTime(Date date) {
        return searchFlightRecordExtMapper.deleteByInsertTimeLessThan(date) > 0;
    }
}