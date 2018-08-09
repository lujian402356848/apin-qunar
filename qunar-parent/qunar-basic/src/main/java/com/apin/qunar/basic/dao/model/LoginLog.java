package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String account;

    private Date loginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}