package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class NationalPayFailOrder implements Serializable {
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
    private String flightNum;

    /**
     * 出发城市
     */
    private String deptCity;

    /**
     * 到达城市
     */
    private String arriCity;

    /**
     * 出发日期
     */
    private String deptDate;

    /**
     * 出发时间
     */
    private String deptTime;

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
    public String getFlightNum() {
        return flightNum;
    }

    /**
     * @param flightNum 航班号
     */
    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum == null ? null : flightNum.trim();
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
     * @return 出发日期
     */
    public String getDeptDate() {
        return deptDate;
    }

    /**
     * @param deptDate 出发日期
     */
    public void setDeptDate(String deptDate) {
        this.deptDate = deptDate == null ? null : deptDate.trim();
    }

    /**
     * @return 出发时间
     */
    public String getDeptTime() {
        return deptTime;
    }

    /**
     * @param deptTime 出发时间
     */
    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime == null ? null : deptTime.trim();
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