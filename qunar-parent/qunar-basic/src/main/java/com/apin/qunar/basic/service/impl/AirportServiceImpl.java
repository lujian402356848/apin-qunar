package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.dao.impl.AirportDaoImpl;
import com.apin.qunar.basic.dao.impl.AirportSearchDaoImpl;
import com.apin.qunar.basic.dao.model.Airport;
import com.apin.qunar.basic.service.AirportService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 10:58
 */
@Slf4j
@Service
public class AirportServiceImpl implements AirportService {
    private Cache<Integer, Airport> airportCache = CacheBuilder.newBuilder().maximumSize(5000).build();
    @Autowired
    private AirportDaoImpl airportDao;
    @Autowired
    private AirportSearchDaoImpl airportSearchDao;

    @PostConstruct
    public void init() {
        loadAllData();
    }

    private void loadAllData() {
        log.info("开始初始化机场信息");
        List<Airport> airports = airportDao.queryAll();
        if (CollectionUtils.isEmpty(airports)) {
            return;
        }
        for (Airport airport : airports) {
            airportCache.put(airport.getId(), airport);
        }
        log.info("初始化机场信息完毕");
    }

    @Override
    public List<Airport> queryByKeyword(String keyword) {
        List<Airport> airports = new ArrayList<>();
        if (StringUtils.isBlank(keyword)) {
            return airports;
        }
        Airport airport = null;
        try {
            List<Integer> airportIds = airportSearchDao.queryAirportIdByKeyword(keyword);
            for (Integer airportId : airportIds) {
                airport = airportCache.getIfPresent(airportId);
                if (airport != null) {
                    airports.add(airport);
                }
            }
        } catch (Exception e) {
            log.error("查询机场信息异常,keyword:{}", keyword, e);
        }
        return airports;
    }
}
