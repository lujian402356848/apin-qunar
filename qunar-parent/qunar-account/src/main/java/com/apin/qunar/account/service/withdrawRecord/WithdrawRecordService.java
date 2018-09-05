package com.apin.qunar.account.service.withdrawRecord;

import com.apin.qunar.account.domain.withdrawRecord.WithdrawRecordVO;

import java.util.List;

public interface WithdrawRecordService {
    List<WithdrawRecordVO> queryWithdrawRecordListBy(String merchantNo, String account, Integer offset, Integer limit);

}
