package com.apin.qunar.basic.domain.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO {
    private Long id;
    private String merchantNo;
    private String account;
    private String password;
    private String realName;
    private String department;
    private Integer accountType;
    private Integer hasAdmin;
    private Integer hasEnable;
    private Date insertTime;
    private Date updateTime;
    private String secretKey;
}