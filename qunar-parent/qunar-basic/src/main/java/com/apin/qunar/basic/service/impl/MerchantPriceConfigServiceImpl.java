package com.apin.qunar.basic.service.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.dao.impl.MerchantPriceConfigDaoImpl;
import com.apin.qunar.basic.dao.model.MerchantPriceConfig;
import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-02 14:41
 */

@Slf4j
@Service
public class MerchantPriceConfigServiceImpl implements MerchantPriceConfigService {
    private Cache<String, MerchantPriceConfig> priceConfigCache = CacheBuilder.newBuilder().maximumSize(1000).build();
    @Autowired
    private MerchantPriceConfigDaoImpl merchantPriceConfigDao;

    private Date lastUpdateTime = null;

    @PostConstruct
    public void init() {
        loadAllData();
    }

    private void loadAllData() {
        log.info("开始初始化商户价格配置信息");
        List<MerchantPriceConfig> priceConfigs = merchantPriceConfigDao.queryAll();
        if (CollectionUtils.isEmpty(priceConfigs)) {
            return;
        }
        for (MerchantPriceConfig priceConfig : priceConfigs) {
            priceConfigCache.put(priceConfig.getMerchantNo(), priceConfig);
        }
        setLastUpdateTime(priceConfigs);
        log.info("初始化商户价格配置信息完毕");
    }

    @Scheduled(initialDelay = 60 * 1000, fixedDelay = 60 * 1000)
    private void syncData() {
        List<MerchantPriceConfig> priceConfigs = merchantPriceConfigDao.queryByLastUpdateTime(lastUpdateTime);
        for (MerchantPriceConfig priceConfig : priceConfigs) {
            priceConfigCache.put(priceConfig.getMerchantNo(), priceConfig);
            log.info("同步商户价格配置信息:{}", JSON.toJSON(priceConfig));
        }
        setLastUpdateTime(priceConfigs);
    }

    private void setLastUpdateTime(List<MerchantPriceConfig> priceConfigs) {
        if (CollectionUtils.isEmpty(priceConfigs)) {
            return;
        }
        lastUpdateTime = priceConfigs.stream().filter(p -> p.getUpdateTime() != null).max(Comparator.comparing(MerchantPriceConfig::getUpdateTime)).get().getUpdateTime();
        log.info("当前商户价格配置最大更新时间:{}", lastUpdateTime);
    }

    @Override
    public double queryPriceRatio(String merchantNo, boolean hasNational) {
        double priceRatio = 1;
        MerchantPriceConfig merchantPriceConfig = priceConfigCache.getIfPresent(merchantNo);
        if (merchantPriceConfig == null) {
            return priceRatio;
        }
        return hasNational ? merchantPriceConfig.getNationalPriceRatio() : merchantPriceConfig.getInternationalPriceRatio();
    }
}
