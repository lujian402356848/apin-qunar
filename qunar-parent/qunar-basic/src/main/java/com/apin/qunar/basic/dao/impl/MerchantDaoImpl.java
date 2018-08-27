package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.MerchantExtMapper;
import com.apin.qunar.basic.dao.mapper.MerchantMapper;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.dao.model.MerchantExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-23 14:28
 */
@Repository
public class MerchantDaoImpl {
    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private MerchantExtMapper merchantExtMapper;

    public Merchant queryByMerchantNo(String merchantNo) {
        if (StringUtils.isBlank(merchantNo)) {
            return null;
        }
        MerchantExample example = new MerchantExample();
        MerchantExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantNoEqualTo(merchantNo);
        List<Merchant> merchants = merchantMapper.selectByExample(example);
        return CollectionUtils.isEmpty(merchants) ? null : merchants.get(0);
    }

    public Merchant queryByContactMobile(String contactMobile) {
        if (StringUtils.isBlank(contactMobile)) {
            return null;
        }
        MerchantExample example = new MerchantExample();
        MerchantExample.Criteria criteria = example.createCriteria();
        criteria.andContactMobileEqualTo(contactMobile);
        List<Merchant> merchants = merchantMapper.selectByExample(example);
        return CollectionUtils.isEmpty(merchants) ? null : merchants.get(0);
    }

    public List<Merchant> querySubordinateMerchant(String contactMobile) {
        if (StringUtils.isBlank(contactMobile)) {
            return null;
        }
        List<Merchant> merchants = merchantExtMapper.querySubordinateMerchant(contactMobile);
        return merchants;
    }

    public boolean isExistContactMobile(String contactMobile) {
        if (StringUtils.isBlank(contactMobile)) {
            return false;
        }
        MerchantExample example = new MerchantExample();
        MerchantExample.Criteria criteria = example.createCriteria();
        criteria.andContactMobileEqualTo(contactMobile);
        return merchantMapper.countByExample(example) > 0;
    }

    public boolean isExistParentInviteCode(String parentInviteCode) {
        if (StringUtils.isBlank(parentInviteCode)) {
            return false;
        }
        MerchantExample example = new MerchantExample();
        MerchantExample.Criteria criteria = example.createCriteria();
        criteria.andInviteCodeEqualTo(parentInviteCode);
        return merchantMapper.countByExample(example) == 0;
    }

    public String querySecretKeyBy(String merchantNo) {
        return merchantExtMapper.queryUserSecretKey(merchantNo);
    }

    public List<Merchant> queryBy(Integer auditStatus, Date auditTime) {
        MerchantExample example = new MerchantExample();
        MerchantExample.Criteria criteria = example.createCriteria();
        if (auditStatus >= 0) {
            criteria.andAuditStatusEqualTo(auditStatus);
        }
        if (auditTime != null) {
            criteria.andAuditTimeGreaterThan(auditTime);
        }
        return merchantMapper.selectByExample(example);
    }

    public List<Merchant> queryPageListBy(Integer offset, Integer limit) {
        MerchantExample example = new MerchantExample();
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return merchantMapper.selectByExample(example);
    }

    public boolean update(Merchant merchant) {
        return merchantMapper.updateByPrimaryKeySelective(merchant) > 0;
    }

    public boolean insert(Merchant merchant) {
        return merchantMapper.insert(merchant) > 0;
    }
}
