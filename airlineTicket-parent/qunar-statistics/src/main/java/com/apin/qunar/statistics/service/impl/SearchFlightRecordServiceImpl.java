package com.apin.qunar.statistics.service.impl;

import com.apin.qunar.statistics.dao.impl.InternationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.impl.NationalSearchFlightRecordDaoImpl;
import com.apin.qunar.statistics.dao.model.InternationalSearchFlightRecord;
import com.apin.qunar.statistics.dao.model.NationalSearchFlightRecord;
import com.apin.qunar.statistics.service.SearchFlightRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    public void create(String account, boolean hasInternal, String deptCity, String arriCity) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(deptCity) || StringUtils.isBlank(arriCity)) {
            log.warn("创建航班查询记录有数据为空:account:{},deptCity:{},arriCity:{}", account, deptCity, arriCity);
            return;
        }
        try {
            if (hasInternal) {
                nationalSearchFlightRecordDao.insert(buildNationalSearchFlightRecord(account, deptCity, arriCity));
            } else {
                internationalSearchFlightRecordDao.insert(buildInternationalSearchFlightRecord(account, deptCity, arriCity));
            }
        } catch (Exception e) {
            log.error("添加查询航班记录异常");
        }
    }

    private NationalSearchFlightRecord buildNationalSearchFlightRecord(final String account, final String deptCity, final String arriCity) {
        NationalSearchFlightRecord searchFlightRecord = new NationalSearchFlightRecord();
        searchFlightRecord.setAccount(account);
        searchFlightRecord.setDeptCity(deptCity);
        searchFlightRecord.setArriCity(arriCity);
        return searchFlightRecord;
    }

    private InternationalSearchFlightRecord buildInternationalSearchFlightRecord(final String account, final String deptCity, final String arriCity) {
        InternationalSearchFlightRecord searchFlightRecord = new InternationalSearchFlightRecord();
        searchFlightRecord.setAccount(account);
        searchFlightRecord.setDeptCity(deptCity);
        searchFlightRecord.setArriCity(arriCity);
        return searchFlightRecord;
    }
}
