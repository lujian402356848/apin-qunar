package com.apin.qunar.account.dao.impl;

import com.apin.qunar.account.dao.mapper.WithdrawRecordMapper;
import com.apin.qunar.account.dao.model.WithdrawRecord;
import com.apin.qunar.account.dao.model.WithdrawRecordExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WithdrawRecordDaoImpl {
    @Autowired
    private WithdrawRecordMapper withdrawRecordMapper;

    public List<WithdrawRecord> queryWithdrawRecordListBy(String merchantNo, String accountId, Integer offset, Integer limit) {
        WithdrawRecordExample example = new WithdrawRecordExample();
        WithdrawRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(merchantNo)) {
            criteria.andMerchantNoEqualTo(merchantNo);
        }
        if (StringUtils.isNotBlank(accountId)) {
            criteria.andAccountIdEqualTo(accountId);
        }
        example.setMysqlOffset(offset);
        example.setMysqlLength(limit);
        example.setOrderByClause("insert_time desc");
        return withdrawRecordMapper.selectByExample(example);
    }
}
