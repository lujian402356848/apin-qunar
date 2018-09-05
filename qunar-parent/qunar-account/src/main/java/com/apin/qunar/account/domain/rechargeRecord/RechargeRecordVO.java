package com.apin.qunar.account.domain.rechargeRecord;

import lombok.Data;

import java.util.Date;
@Data
public class RechargeRecordVO {
    private String id;
    private String merchantNo;
    private String accountId;
    private Integer rechargeMoney;
    private Integer rechargeStatus;
    private String remark;
    private Date insertTime;
}
