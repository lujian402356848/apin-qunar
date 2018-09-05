package com.apin.qunar.account.dao.model;

import java.io.Serializable;
import java.util.Date;

public class RechargeRecord implements Serializable {
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
     * 充值账户
     */
    private String accountId;

    /**
     * 充值金额
     */
    private Integer rechargeMoney;

    /**
     * 充值状态
     */
    private Integer rechargeStatus;

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
     * @return 充值账户
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId 充值账户
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * @return 充值金额
     */
    public Integer getRechargeMoney() {
        return rechargeMoney;
    }

    /**
     * @param rechargeMoney 充值金额
     */
    public void setRechargeMoney(Integer rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    /**
     * @return 充值状态
     */
    public Integer getRechargeStatus() {
        return rechargeStatus;
    }

    /**
     * @param rechargeStatus 充值状态
     */
    public void setRechargeStatus(Integer rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
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