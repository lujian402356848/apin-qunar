package com.apin.qunar.statistics.service.impl;

import com.apin.qunar.statistics.dao.impl.InternationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.impl.NationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.model.InternationalSearchFlightRecord;
import com.apin.qunar.statistics.dao.model.NationalSearchFlightRecord;
import com.apin.qunar.statistics.service.SearchFlightRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SearchFlightRecordServiceImpl implements SearchFlightRecordService {
    @Autowired
    private NationalSearchFlightRecordDaoImpl nationalSearchFlightRecordDao;
    @Autowired
    private InternationalSearchFlightRecordDaoImpl internationalSearchFlightRecordDao;

    @Override
    public void create(String merchantNo, boolean hasInternal, String deptCity, String arriCity) {
        try {
            if (hasInternal) {
                nationalSearchFlightRecordDao.insert(buildNationalSearchFlightRecord(merchantNo, deptCity, arriCity));
            } else {
                internationalSearchFlightRecordDao.insert(buildInternationalSearchFlightRecord(merchantNo, deptCity, arriCity));
            }
        } catch (Exception e) {
            log.error("添加查询航班记录异常");
        }
    }

    private NationalSearchFlightRecord buildNationalSearchFlightRecord(final String merchantNo, final String deptCity, final String arriCity) {
        NationalSearchFlightRecord searchFlightRecord = new NationalSearchFlightRecord();
        searchFlightRecord.setMerchantNo(merchantNo);
        searchFlightRecord.setDeptCity(deptCity);
        searchFlightRecord.setArriCity(arriCity);
        return searchFlightRecord;
    }

    private InternationalSearchFlightRecord buildInternationalSearchFlightRecord(final String merchantNo, final String deptCity, final String arriCity) {
        InternationalSearchFlightRecord searchFlightRecord = new InternationalSearchFlightRecord();
        searchFlightRecord.setMerchantNo(merchantNo);
        searchFlightRecord.setDeptCity(deptCity);
        searchFlightRecord.setArriCity(arriCity);
        return searchFlightRecord;
    }
}
