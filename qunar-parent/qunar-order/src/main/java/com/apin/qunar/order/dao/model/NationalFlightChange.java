package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class NationalFlightChange implements Serializable {
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
     * 订单号
     */
    private String orderNo;

    /**
     * 航班号
     */
    private String flightNo;

    /**
     * 出发日期
     */
    private String dptDate;

    /**
     * 出发时间
     */
    private String dptTime;

    /**
     * 到达时间
     */
    private String arrTime;

    /**
     * 出发城市航班三字码
     */
    private String dptAirport;

    /**
     * 到达城市航班三字码
     */
    private String arrAirport;

    /**
     * 变更后航班号
     */
    private String folFlightNo;

    /**
     * 变更后出发日期
     */
    private String folDptDate;

    /**
     * 变更后出发时间
     */
    private String folDptTime;

    /**
     * 变更后到达时间
     */
    private String folArrTime;

    /**
     * 变更出发城市航班三字码
     */
    private String folDptAirport;

    /**
     * 变更后到达城市航班三字码
     */
    private String folArrAirport;

    /**
     * 变更状态
     */
    private String changeStatus;

    /**
     * 是否发送短信(0:未发送,1:已发送)
     */
    private Integer hasSendSms;

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
     * @return 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * @return 航班号
     */
    public String getFlightNo() {
        return flightNo;
    }

    /**
     * @param flightNo 航班号
     */
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo == null ? null : flightNo.trim();
    }

    /**
     * @return 出发日期
     */
    public String getDptDate() {
        return dptDate;
    }

    /**
     * @param dptDate 出发日期
     */
    public void setDptDate(String dptDate) {
        this.dptDate = dptDate == null ? null : dptDate.trim();
    }

    /**
     * @return 出发时间
     */
    public String getDptTime() {
        return dptTime;
    }

    /**
     * @param dptTime 出发时间
     */
    public void setDptTime(String dptTime) {
        this.dptTime = dptTime == null ? null : dptTime.trim();
    }

    /**
     * @return 到达时间
     */
    public String getArrTime() {
        return arrTime;
    }

    /**
     * @param arrTime 到达时间
     */
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime == null ? null : arrTime.trim();
    }

    /**
     * @return 出发城市航班三字码
     */
    public String getDptAirport() {
        return dptAirport;
    }

    /**
     * @param dptAirport 出发城市航班三字码
     */
    public void setDptAirport(String dptAirport) {
        this.dptAirport = dptAirport == null ? null : dptAirport.trim();
    }

    /**
     * @return 到达城市航班三字码
     */
    public String getArrAirport() {
        return arrAirport;
    }

    /**
     * @param arrAirport 到达城市航班三字码
     */
    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport == null ? null : arrAirport.trim();
    }

    /**
     * @return 变更后航班号
     */
    public String getFolFlightNo() {
        return folFlightNo;
    }

    /**
     * @param folFlightNo 变更后航班号
     */
    public void setFolFlightNo(String folFlightNo) {
        this.folFlightNo = folFlightNo == null ? null : folFlightNo.trim();
    }

    /**
     * @return 变更后出发日期
     */
    public String getFolDptDate() {
        return folDptDate;
    }

    /**
     * @param folDptDate 变更后出发日期
     */
    public void setFolDptDate(String folDptDate) {
        this.folDptDate = folDptDate == null ? null : folDptDate.trim();
    }

    /**
     * @return 变更后出发时间
     */
    public String getFolDptTime() {
        return folDptTime;
    }

    /**
     * @param folDptTime 变更后出发时间
     */
    public void setFolDptTime(String folDptTime) {
        this.folDptTime = folDptTime == null ? null : folDptTime.trim();
    }

    /**
     * @return 变更后到达时间
     */
    public String getFolArrTime() {
        return folArrTime;
    }

    /**
     * @param folArrTime 变更后到达时间
     */
    public void setFolArrTime(String folArrTime) {
        this.folArrTime = folArrTime == null ? null : folArrTime.trim();
    }

    /**
     * @return 变更出发城市航班三字码
     */
    public String getFolDptAirport() {
        return folDptAirport;
    }

    /**
     * @param folDptAirport 变更出发城市航班三字码
     */
    public void setFolDptAirport(String folDptAirport) {
        this.folDptAirport = folDptAirport == null ? null : folDptAirport.trim();
    }

    /**
     * @return 变更后到达城市航班三字码
     */
    public String getFolArrAirport() {
        return folArrAirport;
    }

    /**
     * @param folArrAirport 变更后到达城市航班三字码
     */
    public void setFolArrAirport(String folArrAirport) {
        this.folArrAirport = folArrAirport == null ? null : folArrAirport.trim();
    }

    /**
     * @return 变更状态
     */
    public String getChangeStatus() {
        return changeStatus;
    }

    /**
     * @param changeStatus 变更状态
     */
    public void setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus == null ? null : changeStatus.trim();
    }

    /**
     * @return 是否发送短信(0:未发送,1:已发送)
     */
    public Integer getHasSendSms() {
        return hasSendSms;
    }

    /**
     * @param hasSendSms 是否发送短信(0:未发送,1:已发送)
     */
    public void setHasSendSms(Integer hasSendSms) {
        this.hasSendSms = hasSendSms;
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