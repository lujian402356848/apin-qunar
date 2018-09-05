package com.apin.qunar.account.service.withdrawRecord.impl;

import com.apin.qunar.account.dao.impl.WithdrawRecordDaoImpl;
import com.apin.qunar.account.dao.model.WithdrawRecord;
import com.apin.qunar.account.domain.withdrawRecord.WithdrawRecordVO;
import com.apin.qunar.account.service.withdrawRecord.WithdrawRecordService;
import com.apin.qunar.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawRecordServiceImpl implements WithdrawRecordService {
    @Autowired
    private WithdrawRecordDaoImpl withdrawRecordDao;

    @Override
    public List<WithdrawRecordVO> queryWithdrawRecordListBy(String merchantNo, String account, Integer offset, Integer limit) {
        List<WithdrawRecord> withdrawRecords = withdrawRecordDao.queryWithdrawRecordListBy(merchantNo, account, offset, limit);
        return BeanUtil.copyProperties(withdrawRecords, WithdrawRecordVO.class);
    }
}
