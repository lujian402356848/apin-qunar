package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.dao.impl.AirlinePriceRateDaoImpl;
import com.apin.qunar.basic.dao.model.AirlinePriceRate;
import com.apin.qunar.basic.service.AirlinePriceRateService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class AirlinePriceRateServiceImpl implements AirlinePriceRateService {
    private Cache<String, AirlinePriceRate> airlinePriceRateCache = CacheBuilder.newBuilder().maximumSize(1000).build();
    @Autowired
    private AirlinePriceRateDaoImpl airlinePriceRateDao;

    @PostConstruct
    public void init() {
        loadAllData();
    }

    private void loadAllData() {
        log.info("开始初始化航司价格折扣信息");
        List<AirlinePriceRate> airlinePriceRates = airlinePriceRateDao.queryAll();
        if (CollectionUtils.isEmpty(airlinePriceRates)) {
            return;
        }
        for (AirlinePriceRate airlinePriceRate : airlinePriceRates) {
            airlinePriceRateCache.put(airlinePriceRate.getCode() + "-" + airlinePriceRate.getPosition(), airlinePriceRate);
        }
        log.info("初始化航司价格折扣信息完毕");
    }

    @Override
    public AirlinePriceRate queryByCode(String code, String position) {
        return airlinePriceRateCache.getIfPresent(code + "-" + position);
    }
}
