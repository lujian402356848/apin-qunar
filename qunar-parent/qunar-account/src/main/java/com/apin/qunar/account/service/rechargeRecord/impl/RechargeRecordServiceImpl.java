package com.apin.qunar.account.service.rechargeRecord.impl;

import com.apin.qunar.account.dao.impl.RechargeRecordDaoImpl;
import com.apin.qunar.account.dao.model.RechargeRecord;
import com.apin.qunar.account.domain.rechargeRecord.RechargeRecordVO;
import com.apin.qunar.account.service.rechargeRecord.RechargeRecordService;
import com.apin.qunar.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeRecordServiceImpl implements RechargeRecordService {
    @Autowired
    private RechargeRecordDaoImpl rechargeRecordDao;

    @Override
    public List<RechargeRecordVO> queryPageListBy(String merchantNo, String account, Integer offset, Integer limit) {
        List<RechargeRecord> rechargeRecords = rechargeRecordDao.queryRechargeRecordListBy(merchantNo,account,offset,limit);
        return BeanUtil.copyProperties(rechargeRecords,RechargeRecordVO.class);
    }
}
