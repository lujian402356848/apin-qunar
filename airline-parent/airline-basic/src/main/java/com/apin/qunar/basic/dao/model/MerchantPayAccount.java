package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class MerchantPayAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 支付账户
     */
    private String account;

    /**
     * 支付账户类型(1:支付宝)
     */
    private Integer accountType;

    /**
     * 支付账户状态
     */
    private Integer accountStaus;

    /**
     * 支付授权密码
     */
    private String authPassword;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * @return 唯一标识
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 唯一标识
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * @param merchantNo 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * @return 支付账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account 支付账户
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * @return 支付账户类型(1:支付宝)
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * @param accountType 支付账户类型(1:支付宝)
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * @return 支付账户状态
     */
    public Integer getAccountStaus() {
        return accountStaus;
    }

    /**
     * @param accountStaus 支付账户状态
     */
    public void setAccountStaus(Integer accountStaus) {
        this.accountStaus = accountStaus;
    }

    /**
     * @return 支付授权密码
     */
    public String getAuthPassword() {
        return authPassword;
    }

    /**
     * @param authPassword 支付授权密码
     */
    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword == null ? null : authPassword.trim();
    }

    /**
     * @return 插入时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 插入时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}