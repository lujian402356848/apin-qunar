package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class InternationalFlightChange implements Serializable {
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
     * 起飞日期
     */
    private String dptDate;

    /**
     * 出发机场三字码
     */
    private String dptAirport;

    /**
     * 到达机场三字码
     */
    private String arrAirport;

    /**
     * 原航班的起飞时间
     */
    private String dptTime;

    /**
     * 原航班的到达时间
     */
    private String arrTime;

    /**
     * 变更后的航班号
     */
    private String folFlightNo;

    /**
     * 变更后起飞日期
     */
    private String folDptDate;

    /**
     * 变更后到达日期
     */
    private String folArrDate;

    /**
     * 变更后起飞时间
     */
    private String folDptTime;

    /**
     * 变更后到达时间
     */
    private String folArrTime;

    /**
     * 变更后出发机场三字码
     */
    private String folDptAirport;

    /**
     * 变更后到达机场三字码
     */
    private String folArrAirport;

    /**
     * 变更后起飞航站楼
     */
    private String folFptTower;

    /**
     * 变更后到达航站楼
     */
    private String folArrTower;

    /**
     * 航变短信的内容
     */
    private String smsContent;

    /**
     * 短信中航班状态描述符
     */
    private String status;

    /**
     * 详见status即可
     */
    private String initStatus;

    /**
     * 是否要确认座位(1:需要，2:不需要)
     */
    private Integer ensure;

    /**
     * 短信中航司电话
     */
    private String airLineTel;

    /**
     * 航变类型
     */
    private String fcStatus;

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
     * @return 起飞日期
     */
    public String getDptDate() {
        return dptDate;
    }

    /**
     * @param dptDate 起飞日期
     */
    public void setDptDate(String dptDate) {
        this.dptDate = dptDate == null ? null : dptDate.trim();
    }

    /**
     * @return 出发机场三字码
     */
    public String getDptAirport() {
        return dptAirport;
    }

    /**
     * @param dptAirport 出发机场三字码
     */
    public void setDptAirport(String dptAirport) {
        this.dptAirport = dptAirport == null ? null : dptAirport.trim();
    }

    /**
     * @return 到达机场三字码
     */
    public String getArrAirport() {
        return arrAirport;
    }

    /**
     * @param arrAirport 到达机场三字码
     */
    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport == null ? null : arrAirport.trim();
    }

    /**
     * @return 原航班的起飞时间
     */
    public String getDptTime() {
        return dptTime;
    }

    /**
     * @param dptTime 原航班的起飞时间
     */
    public void setDptTime(String dptTime) {
        this.dptTime = dptTime == null ? null : dptTime.trim();
    }

    /**
     * @return 原航班的到达时间
     */
    public String getArrTime() {
        return arrTime;
    }

    /**
     * @param arrTime 原航班的到达时间
     */
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime == null ? null : arrTime.trim();
    }

    /**
     * @return 变更后的航班号
     */
    public String getFolFlightNo() {
        return folFlightNo;
    }

    /**
     * @param folFlightNo 变更后的航班号
     */
    public void setFolFlightNo(String folFlightNo) {
        this.folFlightNo = folFlightNo == null ? null : folFlightNo.trim();
    }

    /**
     * @return 变更后起飞日期
     */
    public String getFolDptDate() {
        return folDptDate;
    }

    /**
     * @param folDptDate 变更后起飞日期
     */
    public void setFolDptDate(String folDptDate) {
        this.folDptDate = folDptDate == null ? null : folDptDate.trim();
    }

    /**
     * @return 变更后到达日期
     */
    public String getFolArrDate() {
        return folArrDate;
    }

    /**
     * @param folArrDate 变更后到达日期
     */
    public void setFolArrDate(String folArrDate) {
        this.folArrDate = folArrDate == null ? null : folArrDate.trim();
    }

    /**
     * @return 变更后起飞时间
     */
    public String getFolDptTime() {
        return folDptTime;
    }

    /**
     * @param folDptTime 变更后起飞时间
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
     * @return 变更后出发机场三字码
     */
    public String getFolDptAirport() {
        return folDptAirport;
    }

    /**
     * @param folDptAirport 变更后出发机场三字码
     */
    public void setFolDptAirport(String folDptAirport) {
        this.folDptAirport = folDptAirport == null ? null : folDptAirport.trim();
    }

    /**
     * @return 变更后到达机场三字码
     */
    public String getFolArrAirport() {
        return folArrAirport;
    }

    /**
     * @param folArrAirport 变更后到达机场三字码
     */
    public void setFolArrAirport(String folArrAirport) {
        this.folArrAirport = folArrAirport == null ? null : folArrAirport.trim();
    }

    /**
     * @return 变更后起飞航站楼
     */
    public String getFolFptTower() {
        return folFptTower;
    }

    /**
     * @param folFptTower 变更后起飞航站楼
     */
    public void setFolFptTower(String folFptTower) {
        this.folFptTower = folFptTower == null ? null : folFptTower.trim();
    }

    /**
     * @return 变更后到达航站楼
     */
    public String getFolArrTower() {
        return folArrTower;
    }

    /**
     * @param folArrTower 变更后到达航站楼
     */
    public void setFolArrTower(String folArrTower) {
        this.folArrTower = folArrTower == null ? null : folArrTower.trim();
    }

    /**
     * @return 航变短信的内容
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * @param smsContent 航变短信的内容
     */
    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    /**
     * @return 短信中航班状态描述符
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 短信中航班状态描述符
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 详见status即可
     */
    public String getInitStatus() {
        return initStatus;
    }

    /**
     * @param initStatus 详见status即可
     */
    public void setInitStatus(String initStatus) {
        this.initStatus = initStatus == null ? null : initStatus.trim();
    }

    /**
     * @return 是否要确认座位(1:需要，2:不需要)
     */
    public Integer getEnsure() {
        return ensure;
    }

    /**
     * @param ensure 是否要确认座位(1:需要，2:不需要)
     */
    public void setEnsure(Integer ensure) {
        this.ensure = ensure;
    }

    /**
     * @return 短信中航司电话
     */
    public String getAirLineTel() {
        return airLineTel;
    }

    /**
     * @param airLineTel 短信中航司电话
     */
    public void setAirLineTel(String airLineTel) {
        this.airLineTel = airLineTel == null ? null : airLineTel.trim();
    }

    /**
     * @return 航变类型
     */
    public String getFcStatus() {
        return fcStatus;
    }

    /**
     * @param fcStatus 航变类型
     */
    public void setFcStatus(String fcStatus) {
        this.fcStatus = fcStatus == null ? null : fcStatus.trim();
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