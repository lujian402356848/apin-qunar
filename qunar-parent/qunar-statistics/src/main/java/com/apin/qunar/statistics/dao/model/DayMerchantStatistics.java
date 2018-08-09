package com.apin.qunar.statistics.dao.model;

import java.io.Serializable;

public class DayMerchantStatistics implements Serializable {
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
     * 商户的日访问次数
     */
    private Integer merchantPv;

    /**
     * 每日国内航班查询次数
     */
    private Integer searchNationalFlightCnt;

    /**
     * 每日国际航班查询次数
     */
    private Integer searchInternationalFlightCnt;

    /**
     * 日成交单数
     */
    private Integer dealOrderCnt;

    /**
     * 日成交总金额
     */
    private Integer dealTotalAmount;

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
     * @return 商户的日访问次数
     */
    public Integer getMerchantPv() {
        return merchantPv;
    }

    /**
     * @param merchantPv 商户的日访问次数
     */
    public void setMerchantPv(Integer merchantPv) {
        this.merchantPv = merchantPv;
    }

    /**
     * @return 每日国内航班查询次数
     */
    public Integer getSearchNationalFlightCnt() {
        return searchNationalFlightCnt;
    }

    /**
     * @param searchNationalFlightCnt 每日国内航班查询次数
     */
    public void setSearchNationalFlightCnt(Integer searchNationalFlightCnt) {
        this.searchNationalFlightCnt = searchNationalFlightCnt;
    }

    /**
     * @return 每日国际航班查询次数
     */
    public Integer getSearchInternationalFlightCnt() {
        return searchInternationalFlightCnt;
    }

    /**
     * @param searchInternationalFlightCnt 每日国际航班查询次数
     */
    public void setSearchInternationalFlightCnt(Integer searchInternationalFlightCnt) {
        this.searchInternationalFlightCnt = searchInternationalFlightCnt;
    }

    /**
     * @return 日成交单数
     */
    public Integer getDealOrderCnt() {
        return dealOrderCnt;
    }

    /**
     * @param dealOrderCnt 日成交单数
     */
    public void setDealOrderCnt(Integer dealOrderCnt) {
        this.dealOrderCnt = dealOrderCnt;
    }

    /**
     * @return 日成交总金额
     */
    public Integer getDealTotalAmount() {
        return dealTotalAmount;
    }

    /**
     * @param dealTotalAmount 日成交总金额
     */
    public void setDealTotalAmount(Integer dealTotalAmount) {
        this.dealTotalAmount = dealTotalAmount;
    }
}