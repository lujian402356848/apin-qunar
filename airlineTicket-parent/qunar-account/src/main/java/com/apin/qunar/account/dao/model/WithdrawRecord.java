package com.apin.qunar.account.dao.model;

import java.io.Serializable;
import java.util.Date;

public class WithdrawRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private String id;

    /**
     * 商户id
     */
    private String merchantNo;

    /**
     * 提现账户
     */
    private String accountId;

    /**
     * 提现金额
     */
    private Integer withdrawMoney;

    /**
     * 提现状态
     */
    private Integer withdrawStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * @return 唯一标识
     */
    public String getId() {
        return id;
    }

    /**
     * @param id 唯一标识
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return 商户id
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * @param merchantNo 商户id
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * @return 提现账户
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId 提现账户
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * @return 提现金额
     */
    public Integer getWithdrawMoney() {
        return withdrawMoney;
    }

    /**
     * @param withdrawMoney 提现金额
     */
    public void setWithdrawMoney(Integer withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    /**
     * @return 提现状态
     */
    public Integer getWithdrawStatus() {
        return withdrawStatus;
    }

    /**
     * @param withdrawStatus 提现状态
     */
    public void setWithdrawStatus(Integer withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}