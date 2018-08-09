package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.MerchantPriceConfigMapper;
import com.apin.qunar.basic.dao.model.MerchantPriceConfig;
import com.apin.qunar.basic.dao.model.MerchantPriceConfigExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-02 14:39
 */

@Repository
public class MerchantPriceConfigDaoImpl {
    @Autowired
    private MerchantPriceConfigMapper merchantPriceConfigMapper;

    public List<MerchantPriceConfig> queryAll() {
        return merchantPriceConfigMapper.selectByExample(null);
    }

    public MerchantPriceConfig queryByMerchantNo(String merchantNo) {
        if (StringUtils.isBlank(merchantNo)) {
            return null;
        }
        MerchantPriceConfigExample example = new MerchantPriceConfigExample();
        MerchantPriceConfigExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantNoEqualTo(merchantNo);
        List<MerchantPriceConfig> merchantPriceConfig = merchantPriceConfigMapper.selectByExample(example);
        return CollectionUtils.isEmpty(merchantPriceConfig) ? null : merchantPriceConfig.get(0);
    }

    public List<MerchantPriceConfig> queryByLastUpdateTime(Date lastUpdateTime) {
        if (lastUpdateTime == null) {
            return new ArrayList<>();
        }
        MerchantPriceConfigExample example = new MerchantPriceConfigExample();
        MerchantPriceConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUpdateTimeGreaterThan(lastUpdateTime);
        return merchantPriceConfigMapper.selectByExample(example);
    }
}
