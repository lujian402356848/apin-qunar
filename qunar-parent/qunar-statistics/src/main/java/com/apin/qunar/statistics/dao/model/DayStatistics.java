package com.apin.qunar.statistics.dao.model;

import java.io.Serializable;

public class DayStatistics implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 总访问pv
     */
    private Integer totalPv;

    /**
     * 总访问uv
     */
    private Integer totalUv;

    /**
     * 每日航班查询次数
     */
    private Integer searchNationalFlightCnt;

    private String searchInternationalFlightCnt;

    /**
     * 每日成交订单数
     */
    private Integer dealOrderCnt;

    /**
     * 每日成交流水
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
     * @return 总访问pv
     */
    public Integer getTotalPv() {
        return totalPv;
    }

    /**
     * @param totalPv 总访问pv
     */
    public void setTotalPv(Integer totalPv) {
        this.totalPv = totalPv;
    }

    /**
     * @return 总访问uv
     */
    public Integer getTotalUv() {
        return totalUv;
    }

    /**
     * @param totalUv 总访问uv
     */
    public void setTotalUv(Integer totalUv) {
        this.totalUv = totalUv;
    }

    /**
     * @return 每日航班查询次数
     */
    public Integer getSearchNationalFlightCnt() {
        return searchNationalFlightCnt;
    }

    /**
     * @param searchNationalFlightCnt 每日航班查询次数
     */
    public void setSearchNationalFlightCnt(Integer searchNationalFlightCnt) {
        this.searchNationalFlightCnt = searchNationalFlightCnt;
    }

    public String getSearchInternationalFlightCnt() {
        return searchInternationalFlightCnt;
    }

    public void setSearchInternationalFlightCnt(String searchInternationalFlightCnt) {
        this.searchInternationalFlightCnt = searchInternationalFlightCnt == null ? null : searchInternationalFlightCnt.trim();
    }

    /**
     * @return 每日成交订单数
     */
    public Integer getDealOrderCnt() {
        return dealOrderCnt;
    }

    /**
     * @param dealOrderCnt 每日成交订单数
     */
    public void setDealOrderCnt(Integer dealOrderCnt) {
        this.dealOrderCnt = dealOrderCnt;
    }

    /**
     * @return 每日成交流水
     */
    public Integer getDealTotalAmount() {
        return dealTotalAmount;
    }

    /**
     * @param dealTotalAmount 每日成交流水
     */
    public void setDealTotalAmount(Integer dealTotalAmount) {
        this.dealTotalAmount = dealTotalAmount;
    }
}