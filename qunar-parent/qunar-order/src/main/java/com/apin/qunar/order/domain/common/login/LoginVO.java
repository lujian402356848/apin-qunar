package com.apin.qunar.order.domain.common.login;


import lombok.Data;

/**
 * Created by ligang on 2018/8/10.
 */
@Data
public class LoginVO {
    private String realName;
    private String account;
    private String department;
    private Integer accountType;
    private Integer hasAdmin;
    private String merchantNo;
}
