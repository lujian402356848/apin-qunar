package com.apin.qunar.statistics.dao.model;

import java.io.Serializable;
import java.util.Date;

public class InternationalSearchCityStatistics implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 账户
     */
    private String account;

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