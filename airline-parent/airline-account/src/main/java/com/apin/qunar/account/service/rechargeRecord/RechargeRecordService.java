package com.apin.qunar.account.service.rechargeRecord;

import com.apin.qunar.account.domain.rechargeRecord.RechargeRecordVO;

import java.util.List;

public interface RechargeRecordService {
    List<RechargeRecordVO> queryPageListBy(String merchantNo, String account, Integer offset, Integer limit);
}
