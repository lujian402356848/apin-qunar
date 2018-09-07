package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 登录账户
     */
    private String account;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 登录时间
     */
    private Date loginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 登录账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account 登录账户
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * @return ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * @return 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}