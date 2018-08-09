package com.apin.qunar.statistics.service.impl;

import com.apin.qunar.statistics.dao.impl.SearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.model.SearchFlightRecord;
import com.apin.qunar.statistics.service.SearchFlightRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SearchFlightRecordServiceImpl implements SearchFlightRecordService {

    @Autowired
    private SearchFlightRecordDaoImpl searchFlightRecordDao;

    @Override
    public void create(String merchantNo, boolean hasInternal, String deptCity, String arriCity) {
        try {
            searchFlightRecordDao.insert(buildSearchFlightRecord(merchantNo, hasInternal, deptCity, arriCity));
        } catch (Exception e) {
            log.error("添加查询航班记录异常");
        }
    }

    private SearchFlightRecord buildSearchFlightRecord(final String merchantNo, final boolean hasInternal, final String deptCity, final String arriCity) {
        SearchFlightRecord searchFlightRecord = new SearchFlightRecord();
        searchFlightRecord.setMerchantNo(merchantNo);
        searchFlightRecord.setHasInternal(hasInternal ? 1 : 0);
        searchFlightRecord.setDeptCity(deptCity);
        searchFlightRecord.setArriCity(arriCity);
        return searchFlightRecord;
    }
}
