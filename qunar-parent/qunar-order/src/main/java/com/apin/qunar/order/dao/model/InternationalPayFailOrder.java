package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class InternationalPayFailOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
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
     * 订单创建时间
     */
    private Date orderCreateTime;

    /**
     * 航班号
     */
    private String goFlightNum;

    /**
     * 出发城市
     */
    private String goDeptCity;

    /**
     * 到达城市
     */
    private String goArriCity;

    /**
     * 出发日期
     */
    private String goDeptDate;

    /**
     * 出发时间
     */
    private String goDeptTime;

    /**
     * 航班号
     */
    private String backFlightNum;

    /**
     * 出发城市
     */
    private String backDeptCity;

    /**
     * 到达城市
     */
    private String backArriCity;

    /**
     * 出发日期
     */
    private String backDeptDate;

    /**
     * 出发时间
     */
    private String backDeptTime;

    /**
     * 支付渠道(0:支付宝,1:微信)
     */
    private Integer payChannel;

    /**
     * 支付金额
     */
    private Integer payAmount;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactMobile;

    /**
     * 处理人部门
     */
    private String processDepartment;

    /**
     * 处理的支付金额
     */
    private Integer processPayAmount;

    /**
     * 处理人
     */
    private String processPerson;

    /**
     * 处理状态(0:待处理,1:处理中,2:处理完成)
     */
    private Integer processStatus;

    /**
     * 处理描述
     */
    private String processDesc;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * @return 订单id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 订单id
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
     * @return 订单创建时间
     */
    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    /**
     * @param orderCreateTime 订单创建时间
     */
    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    /**
     * @return 航班号
     */
    public String getGoFlightNum() {
        return goFlightNum;
    }

    /**
     * @param goFlightNum 航班号
     */
    public void setGoFlightNum(String goFlightNum) {
        this.goFlightNum = goFlightNum == null ? null : goFlightNum.trim();
    }

    /**
     * @return 出发城市
     */
    public String getGoDeptCity() {
        return goDeptCity;
    }

    /**
     * @param goDeptCity 出发城市
     */
    public void setGoDeptCity(String goDeptCity) {
        this.goDeptCity = goDeptCity == null ? null : goDeptCity.trim();
    }

    /**
     * @return 到达城市
     */
    public String getGoArriCity() {
        return goArriCity;
    }

    /**
     * @param goArriCity 到达城市
     */
    public void setGoArriCity(String goArriCity) {
        this.goArriCity = goArriCity == null ? null : goArriCity.trim();
    }

    /**
     * @return 出发日期
     */
    public String getGoDeptDate() {
        return goDeptDate;
    }

    /**
     * @param goDeptDate 出发日期
     */
    public void setGoDeptDate(String goDeptDate) {
        this.goDeptDate = goDeptDate == null ? null : goDeptDate.trim();
    }

    /**
     * @return 出发时间
     */
    public String getGoDeptTime() {
        return goDeptTime;
    }

    /**
     * @param goDeptTime 出发时间
     */
    public void setGoDeptTime(String goDeptTime) {
        this.goDeptTime = goDeptTime == null ? null : goDeptTime.trim();
    }

    /**
     * @return 航班号
     */
    public String getBackFlightNum() {
        return backFlightNum;
    }

    /**
     * @param backFlightNum 航班号
     */
    public void setBackFlightNum(String backFlightNum) {
        this.backFlightNum = backFlightNum == null ? null : backFlightNum.trim();
    }

    /**
     * @return 出发城市
     */
    public String getBackDeptCity() {
        return backDeptCity;
    }

    /**
     * @param backDeptCity 出发城市
     */
    public void setBackDeptCity(String backDeptCity) {
        this.backDeptCity = backDeptCity == null ? null : backDeptCity.trim();
    }

    /**
     * @return 到达城市
     */
    public String getBackArriCity() {
        return backArriCity;
    }

    /**
     * @param backArriCity 到达城市
     */
    public void setBackArriCity(String backArriCity) {
        this.backArriCity = backArriCity == null ? null : backArriCity.trim();
    }

    /**
     * @return 出发日期
     */
    public String getBackDeptDate() {
        return backDeptDate;
    }

    /**
     * @param backDeptDate 出发日期
     */
    public void setBackDeptDate(String backDeptDate) {
        this.backDeptDate = backDeptDate == null ? null : backDeptDate.trim();
    }

    /**
     * @return 出发时间
     */
    public String getBackDeptTime() {
        return backDeptTime;
    }

    /**
     * @param backDeptTime 出发时间
     */
    public void setBackDeptTime(String backDeptTime) {
        this.backDeptTime = backDeptTime == null ? null : backDeptTime.trim();
    }

    /**
     * @return 支付渠道(0:支付宝,1:微信)
     */
    public Integer getPayChannel() {
        return payChannel;
    }

    /**
     * @param payChannel 支付渠道(0:支付宝,1:微信)
     */
    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    /**
     * @return 支付金额
     */
    public Integer getPayAmount() {
        return payAmount;
    }

    /**
     * @param payAmount 支付金额
     */
    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * @return 支付时间
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * @param payTime 支付时间
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    /**
     * @return 联系人
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName 联系人
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
     * @return 处理人部门
     */
    public String getProcessDepartment() {
        return processDepartment;
    }

    /**
     * @param processDepartment 处理人部门
     */
    public void setProcessDepartment(String processDepartment) {
        this.processDepartment = processDepartment == null ? null : processDepartment.trim();
    }

    /**
     * @return 处理的支付金额
     */
    public Integer getProcessPayAmount() {
        return processPayAmount;
    }

    /**
     * @param processPayAmount 处理的支付金额
     */
    public void setProcessPayAmount(Integer processPayAmount) {
        this.processPayAmount = processPayAmount;
    }

    /**
     * @return 处理人
     */
    public String getProcessPerson() {
        return processPerson;
    }

    /**
     * @param processPerson 处理人
     */
    public void setProcessPerson(String processPerson) {
        this.processPerson = processPerson == null ? null : processPerson.trim();
    }

    /**
     * @return 处理状态(0:待处理,1:处理中,2:处理完成)
     */
    public Integer getProcessStatus() {
        return processStatus;
    }

    /**
     * @param processStatus 处理状态(0:待处理,1:处理中,2:处理完成)
     */
    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    /**
     * @return 处理描述
     */
    public String getProcessDesc() {
        return processDesc;
    }

    /**
     * @param processDesc 处理描述
     */
    public void setProcessDesc(String processDesc) {
        this.processDesc = processDesc == null ? null : processDesc.trim();
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