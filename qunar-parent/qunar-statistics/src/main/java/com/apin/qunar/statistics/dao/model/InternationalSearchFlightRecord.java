package com.apin.qunar.statistics.dao.model;

import java.io.Serializable;
import java.util.Date;

public class InternationalSearchFlightRecord implements Serializable {
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
     * 出发城市
     */
    private String deptCity;

    /**
     * 到达城市
     */
    private String arriCity;

    /**
     * 插入时间
     */
    private Date insertTime;

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
     * @return 出发城市
     */
    public String getDeptCity() {
        return deptCity;
    }

    /**
     * @param deptCity 出发城市
     */
    public void setDeptCity(String deptCity) {
        this.deptCity = deptCity == null ? null : deptCity.trim();
    }

    /**
     * @return 到达城市
     */
    public String getArriCity() {
        return arriCity;
    }

    /**
     * @param arriCity 到达城市
     */
    public void setArriCity(String arriCity) {
        this.arriCity = arriCity == null ? null : arriCity.trim();
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