package com.apin.qunar.statistics.dao.impl;

import com.apin.qunar.statistics.dao.mapper.SearchFlightRecordExtMapper;
import com.apin.qunar.statistics.dao.mapper.SearchFlightRecordMapper;
import com.apin.qunar.statistics.dao.model.SearchFlightRecord;
import com.apin.qunar.statistics.dao.model.SearchFlightRecordExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SearchFlightRecordDaoImpl {
    @Autowired
    private SearchFlightRecordMapper searchFlightRecordMapper;
    @Autowired
    private SearchFlightRecordExtMapper searchFlightRecordExtMapper;

    public boolean insert(SearchFlightRecord searchFlightRecord) {
        return searchFlightRecordMapper.insert(searchFlightRecord) > 0;
    }

    public List<String> queryMerchantNoByInsertTime(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            return new ArrayList<>();
        }
        return searchFlightRecordExtMapper.queryAllMerchantNo(startTime, endTime);
    }

    public int queryFlightCnt(String merchantNo, Integer hasNational, Date startTime, Date endTime) {
        SearchFlightRecordExample example = new SearchFlightRecordExample();
        SearchFlightRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        criteria.andHasInternalEqualTo(hasNational);
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