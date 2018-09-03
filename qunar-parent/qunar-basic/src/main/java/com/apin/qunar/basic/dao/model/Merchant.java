package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Merchant implements Serializable {
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
     * 商户级别(1,2,3)
     */
    private Integer merchantGrade;

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactMobile;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 企业地址
     */
    private String companyAddress;

    /**
     * BD
     */
    private String managerName;

    /**
     * 父商户号
     */
    private String parentMerchantNo;

    /**
     * 父邀请码
     */
    private String parentInviteCode;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 授信评分
     */
    private Integer creditScore;

    /**
     * 授信金额
     */
    private Integer creditMoney;

    /**
     * 审核人
     */
    private String auditUser;

    /**
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    private Integer auditStatus;

    /**
     * 审核时间
     */
    private Date auditTime;

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
     * @return 商户级别(1,2,3)
     */
    public Integer getMerchantGrade() {
        return merchantGrade;
    }

    /**
     * @param merchantGrade 商户级别(1,2,3)
     */
    public void setMerchantGrade(Integer merchantGrade) {
        this.merchantGrade = merchantGrade;
    }

    /**
     * @return 密钥
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey 密钥
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    /**
     * @return 联系人姓名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName 联系人姓名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * @return 联系人手机号
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * @param contactMobile 联系人手机号
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile == null ? null : contactMobile.trim();
    }

    /**
     * @return 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * @return 企业地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * @param companyAddress 企业地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * @return BD
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param managerName BD
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    /**
     * @return 父商户号
     */
    public String getParentMerchantNo() {
        return parentMerchantNo;
    }

    /**
     * @param parentMerchantNo 父商户号
     */
    public void setParentMerchantNo(String parentMerchantNo) {
        this.parentMerchantNo = parentMerchantNo == null ? null : parentMerchantNo.trim();
    }

    /**
     * @return 父邀请码
     */
    public String getParentInviteCode() {
        return parentInviteCode;
    }

    /**
     * @param parentInviteCode 父邀请码
     */
    public void setParentInviteCode(String parentInviteCode) {
        this.parentInviteCode = parentInviteCode == null ? null : parentInviteCode.trim();
    }

    /**
     * @return 邀请码
     */
    public String getInviteCode() {
        return inviteCode;
    }

    /**
     * @param inviteCode 邀请码
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    /**
     * @return 授信评分
     */
    public Integer getCreditScore() {
        return creditScore;
    }

    /**
     * @param creditScore 授信评分
     */
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * @return 授信金额
     */
    public Integer getCreditMoney() {
        return creditMoney;
    }

    /**
     * @param creditMoney 授信金额
     */
    public void setCreditMoney(Integer creditMoney) {
        this.creditMoney = creditMoney;
    }

    /**
     * @return 审核人
     */
    public String getAuditUser() {
        return auditUser;
    }

    /**
     * @param auditUser 审核人
     */
    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser == null ? null : auditUser.trim();
    }

    /**
     * @return 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * @param auditStatus 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * @return 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
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