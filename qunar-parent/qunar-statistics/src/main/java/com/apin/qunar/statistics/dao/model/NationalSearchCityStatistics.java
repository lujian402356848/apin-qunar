package com.apin.qunar.statistics.dao.model;

import java.io.Serializable;
import java.util.Date;

public class NationalSearchCityStatistics implements Serializable {
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
     * 来回类型(1:去程,2:回程)
     */
    private Integer goBackType;

    /**
     * 城市
     */
    private String city;

    /**
     * 查询次数
     */
    private Integer searchCnt;

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
     * @return 来回类型(1:去程,2:回程)
     */
    public Integer getGoBackType() {
        return goBackType;
    }

    /**
     * @param goBackType 来回类型(1:去程,2:回程)
     */
    public void setGoBackType(Integer goBackType) {
        this.goBackType = goBackType;
    }

    /**
     * @return 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return 查询次数
     */
    public Integer getSearchCnt() {
        return searchCnt;
    }

    /**
     * @param searchCnt 查询次数
     */
    public void setSearchCnt(Integer searchCnt) {
        this.searchCnt = searchCnt;
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