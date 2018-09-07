package com.apin.qunar.basic.domain.merchant;

import lombok.Data;

import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-07-23 14:46
 */
@Data
public class MerchantVO {
    private String merchantNo;
    private String contactName;
    private String contactMobile;
    private String companyName;
    private String companyAddress;
    private String auditUser;
    private Integer auditStatus;
    private Date auditTime;
    private Date insertTime;
    private Date updateTime;
    private String managerName;
}
