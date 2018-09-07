package com.apin.qunar.basic.dao.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
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
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 部门
     */
    private String department;

    /**
     * 账户类型(1:员工账户,2:商户账户)
     */
    private Integer accountType;

    /**
     * 是否为管理员(1:管理员,0:非管理员)
     */
    private Integer hasAdmin;

    /**
     * 是否激活(1:激活,0:不激活)
     */
    private Integer hasEnable;

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
     * @return 账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account 账户
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * @return 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * @return 账户类型(1:员工账户,2:商户账户)
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * @param accountType 账户类型(1:员工账户,2:商户账户)
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * @return 是否为管理员(1:管理员,0:非管理员)
     */
    public Integer getHasAdmin() {
        return hasAdmin;
    }

    /**
     * @param hasAdmin 是否为管理员(1:管理员,0:非管理员)
     */
    public void setHasAdmin(Integer hasAdmin) {
        this.hasAdmin = hasAdmin;
    }

    /**
     * @return 是否激活(1:激活,0:不激活)
     */
    public Integer getHasEnable() {
        return hasEnable;
    }

    /**
     * @param hasEnable 是否激活(1:激活,0:不激活)
     */
    public void setHasEnable(Integer hasEnable) {
        this.hasEnable = hasEnable;
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