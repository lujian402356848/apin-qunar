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
    public void create(SearchFlightRecord searchFlightRecord) {
        try {
            searchFlightRecordDao.insert(searchFlightRecord);
        } catch (Exception e) {
            log.error("添加查询航班记录异常");
        }
    }
}
