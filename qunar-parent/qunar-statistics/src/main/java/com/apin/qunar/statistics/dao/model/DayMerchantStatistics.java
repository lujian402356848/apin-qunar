package com.apin.qunar.statistics.dao.model;

import java.io.Serializable;
import java.util.Date;

public class DayMerchantStatistics implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 用户账户
     */
    private String account;

    /**
     * 国内每日航班查询次数
     */
    private Integer nationalSearchFlightCnt;

    /**
     * 国际每日航班查询次数
     */
    private Integer internationalSearchFlightCnt;

    /**
     * 国内日成交订单数
     */
    private Integer nationalDealOrderCnt;

    /**
     * 国际日成交订单数
     */
    private Integer internationalDealOrderCnt;

    /**
     * 国内日成交总金额
     */
    private Integer nationalDealTotalAmount;

    /**
     * 国际日成交总金额
     */
    private Integer internationalTotalAmount;

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
     * @return 用户账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account 用户账户
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * @return 国内每日航班查询次数
     */
    public Integer getNationalSearchFlightCnt() {
        return nationalSearchFlightCnt;
    }

    /**
     * @param nationalSearchFlightCnt 国内每日航班查询次数
     */
    public void setNationalSearchFlightCnt(Integer nationalSearchFlightCnt) {
        this.nationalSearchFlightCnt = nationalSearchFlightCnt;
    }

    /**
     * @return 国际每日航班查询次数
     */
    public Integer getInternationalSearchFlightCnt() {
        return internationalSearchFlightCnt;
    }

    /**
     * @param internationalSearchFlightCnt 国际每日航班查询次数
     */
    public void setInternationalSearchFlightCnt(Integer internationalSearchFlightCnt) {
        this.internationalSearchFlightCnt = internationalSearchFlightCnt;
    }

    /**
     * @return 国内日成交订单数
     */
    public Integer getNationalDealOrderCnt() {
        return nationalDealOrderCnt;
    }

    /**
     * @param nationalDealOrderCnt 国内日成交订单数
     */
    public void setNationalDealOrderCnt(Integer nationalDealOrderCnt) {
        this.nationalDealOrderCnt = nationalDealOrderCnt;
    }

    /**
     * @return 国际日成交订单数
     */
    public Integer getInternationalDealOrderCnt() {
        return internationalDealOrderCnt;
    }

    /**
     * @param internationalDealOrderCnt 国际日成交订单数
     */
    public void setInternationalDealOrderCnt(Integer internationalDealOrderCnt) {
        this.internationalDealOrderCnt = internationalDealOrderCnt;
    }

    /**
     * @return 国内日成交总金额
     */
    public Integer getNationalDealTotalAmount() {
        return nationalDealTotalAmount;
    }

    /**
     * @param nationalDealTotalAmount 国内日成交总金额
     */
    public void setNationalDealTotalAmount(Integer nationalDealTotalAmount) {
        this.nationalDealTotalAmount = nationalDealTotalAmount;
    }

    /**
     * @return 国际日成交总金额
     */
    public Integer getInternationalTotalAmount() {
        return internationalTotalAmount;
    }

    /**
     * @param internationalTotalAmount 国际日成交总金额
     */
    public void setInternationalTotalAmount(Integer internationalTotalAmount) {
        this.internationalTotalAmount = internationalTotalAmount;
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