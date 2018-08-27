package com.apin.qunar.basic.service.impl;

import com.alibaba.fastjson.JSON;
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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @outhor lujian
 * @create 2018-06-25 10:58
 */
@Slf4j
@Service
public class AirportServiceImpl implements AirportService {
    private Cache<String, Airport> airportCache = CacheBuilder.newBuilder().maximumSize(5000).build();
    @Autowired
    private AirportDaoImpl airportDao;
    @Autowired
    private AirportSearchDaoImpl airportSearchDao;
    private Map<String, String> baoYouCityCode = new HashMap<>(20);
    private Map<String, String> chinaCityCode = new HashMap<>(40);
    private Date maxInsertTime = null;

    @PostConstruct
    public void init() {
        loadAllData();
        loadBaoYouCity();
    }

    private void loadBaoYouCity() {
        baoYouCityCode.put("DPS", "巴厘岛");
        baoYouCityCode.put("HKT", "普吉岛");
        baoYouCityCode.put("BKI", "沙巴");
        baoYouCityCode.put("DAD", "岘港");
        baoYouCityCode.put("CXR", "芽庄");
        baoYouCityCode.put("ROR", "帕劳");
        baoYouCityCode.put("CEB", "宿务");
        baoYouCityCode.put("KBV", "甲米");
        baoYouCityCode.put("MDC", "美娜多");
        baoYouCityCode.put("USM", "苏梅岛");
        baoYouCityCode.put("URT", "万伦");
        baoYouCityCode.put("KLO", "长滩岛,卡里波");
        baoYouCityCode.put("PQC", "富国岛");
        baoYouCityCode.put("NAN", "楠迪");
        baoYouCityCode.put("MRU", "毛里求斯");
        baoYouCityCode.put("SPN", "塞班");
        baoYouCityCode.put("CMB", "科伦坡");
        baoYouCityCode.put("MLE", "马累");
        baoYouCityCode.put("OKD", "塞舌岛");
        baoYouCityCode.put("BKK", "曼谷");
        baoYouCityCode.put("DMK", "曼谷");
        baoYouCityCode.put("CNX", "清迈");
        baoYouCityCode.put("SIN", "新加坡");
        baoYouCityCode.put("KUL", "吉隆坡");
        baoYouCityCode.put("HND", "东京");
        baoYouCityCode.put("NRT", "东京");
        baoYouCityCode.put("KIX", "大阪");
        baoYouCityCode.put("OKA", "冲绳");
        baoYouCityCode.put("FUK", "福冈");
    }

    private void loadAllData() {
        log.info("开始初始化机场信息");
        List<Airport> airports = airportDao.queryAll();
        if (CollectionUtils.isEmpty(airports)) {
            return;
        }
        for (Airport airport : airports) {
            airportCache.put(airport.getAirportCode(), airport);
            if ("CN".equalsIgnoreCase(airport.getCountryCode())) {
                chinaCityCode.put(airport.getAirportCode(), airport.getCityName());
            }
        }
        setMaxInsertTime(airports);
        log.info("初始化机场信息完毕");
    }

    @Scheduled(initialDelay = 60 * 1000, fixedDelay = 60 * 1000)
    private void syncData() {
        List<Airport> airports = airportDao.queryBy(maxInsertTime);
        for (Airport airport : airports) {
            airportCache.put(airport.getAirportCode(), airport);
            log.info("同步机场信息:{}", JSON.toJSON(airport));
        }
        setMaxInsertTime(airports);
    }

    private void setMaxInsertTime(List<Airport> airports) {
        if (CollectionUtils.isEmpty(airports)) {
            return;
        }
        maxInsertTime = airports.stream().filter(p -> p.getInsertTime() != null).max(Comparator.comparing(Airport::getInsertTime)).get().getInsertTime();
        log.info("当前机场最大新增时间:{}", maxInsertTime);
    }

    @Override
    public Airport queryByCode(final String code) {
        return StringUtils.isBlank(code) ? null : airportCache.getIfPresent(code);
    }

    @Override
    public List<Airport> queryByKeyword(final String keyword) {
        List<Airport> airports = new ArrayList<>();
        if (StringUtils.isBlank(keyword)) {
            return airports;
        }
        Airport airport = null;
        try {
            List<String> airportCodes = airportSearchDao.queryAirportCodeByKeyword(keyword);
            for (String airportCode : airportCodes) {
                airport = airportCache.getIfPresent(airportCode);
                if (airport != null) {
                    airports.add(airport);
                }
            }
        } catch (Exception e) {
            log.error("查询机场信息异常,keyword:{}", keyword, e);
        }
        return airports;
    }

    @Override
    public boolean isBaoYouCity(final String cityCode) {
        return StringUtils.isBlank(cityCode) ? false : baoYouCityCode.containsKey(cityCode);
    }

    @Override
    public boolean isChinaCity(final String cityCode) {
        return StringUtils.isBlank(cityCode) ? false : chinaCityCode.containsKey(cityCode);
    }
}
