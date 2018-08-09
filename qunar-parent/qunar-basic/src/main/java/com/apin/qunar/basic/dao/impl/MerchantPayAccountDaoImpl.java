package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.MerchantPayAccountMapper;
import com.apin.qunar.basic.dao.model.MerchantPayAccount;
import com.apin.qunar.basic.dao.model.MerchantPayAccountExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-25 18:51
 */
@Repository
public class MerchantPayAccountDaoImpl {
    @Autowired
    private MerchantPayAccountMapper merchantPayAccountMapper;


    public List<MerchantPayAccount> queryByMerchantNo(String merchantNo) {
        if (StringUtils.isBlank(merchantNo)) {
            return new ArrayList<>();
        }
        MerchantPayAccountExample example = new MerchantPayAccountExample();
        MerchantPayAccountExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantNoEqualTo(merchantNo);
        return merchantPayAccountMapper.selectByExample(example);
    }

    public MerchantPayAccount queryByMerchantNoAndAccount(String merchantNo, String account) {
        if (StringUtils.isBlank(merchantNo) || StringUtils.isBlank(account)) {
            return null;
        }
        MerchantPayAccountExample example = new MerchantPayAccountExample();
        MerchantPayAccountExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantNoEqualTo(merchantNo);
        criteria.andAccountEqualTo(account);
        List<MerchantPayAccount> merchantPayAccounts = merchantPayAccountMapper.selectByExample(example);
        return CollectionUtils.isEmpty(merchantPayAccounts) ? null : merchantPayAccounts.get(0);
    }

    public boolean update(MerchantPayAccount merchantPayAccount) {
        return merchantPayAccountMapper.updateByPrimaryKey(merchantPayAccount) > 0;
    }

    public boolean insert(MerchantPayAccount merchantPayAccount) {
        return merchantPayAccountMapper.insert(merchantPayAccount) > 0;
    }

    public boolean deleteBy(String merchantNo, String account) {
        if (StringUtils.isBlank(merchantNo) || StringUtils.isBlank(account)) {
            return false;
        }
        MerchantPayAccountExample example = new MerchantPayAccountExample();
        MerchantPayAccountExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantNoEqualTo(merchantNo);
        criteria.andAccountEqualTo(account);
        return merchantPayAccountMapper.deleteByExample(example) > 0;
    }
}
