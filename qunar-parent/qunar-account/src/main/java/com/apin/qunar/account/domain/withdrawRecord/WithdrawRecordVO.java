package com.apin.qunar.account.domain.withdrawRecord;

import lombok.Data;

import java.util.Date;
@Data
public class WithdrawRecordVO {
    private String id;
    private String merchantNo;
    private String accountId;
    private Integer withdrawMoney;
    private Integer withdrawStatus;
    private String remark;
    private Date insertTime;
}
