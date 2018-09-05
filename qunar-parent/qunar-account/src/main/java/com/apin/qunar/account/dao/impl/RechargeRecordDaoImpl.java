package com.apin.qunar.account.dao.impl;

import com.apin.qunar.account.dao.mapper.RechargeRecordMapper;
import com.apin.qunar.account.dao.model.RechargeRecord;
import com.apin.qunar.account.dao.model.RechargeRecordExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RechargeRecordDaoImpl {
//    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    public List<RechargeRecord> queryRechargeRecordListBy(String merchantNo, String accountId, Integer offset, Integer limit) {
        RechargeRecordExample example = new RechargeRecordExample();
        RechargeRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(accountId)) {
            criteria.andAccountIdEqualTo(accountId);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return rechargeRecordMapper.selectByExample(example);
    }
}
