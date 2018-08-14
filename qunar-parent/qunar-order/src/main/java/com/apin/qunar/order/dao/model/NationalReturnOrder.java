package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class NationalReturnOrder implements Serializable {
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
     * 父订单号
     */
    private String parentOrderNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 票号
     */
    private String ticketNo;

    /**
     * 航班号
     */
    private String flightNum;

    /**
     * 主飞航班
     */
    private String actFlightNum;

    /**
     * 航空公司编号
     */
    private String carrierCode;

    /**
     * 航空公司名称
     */
    private String carrierName;

    /**
     * 出发城市
     */
    private String deptCity;

    /**
     * 到达城市
     */
    private String arriCity;

    /**
     * 起飞机场名称
     */
    private String deptAirportName;

    /**
     * 到达机场名称
     */
    private String arriAirportName;

    /**
     * 出发日期
     */
    private String deptDate;

    /**
     * 出发时间
     */
    private String deptTime;

    /**
     * 到达时间
     */
    private String arriTime;

    /**
     * 退票原因编号
     */
    private Integer reteunCode;

    /**
     * 是否可退（1-不可退，2-可退）
     */
    private Integer hasDisabled;

    /**
     * 不可退原因
     */
    private String disableReason;

    /**
     * 退票状态
     */
    private Integer returnStatus;

    /**
     * 退票时间
     */
    private String returnTime;

    /**
     * 退票金额
     */
    private Integer returnFee;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactMobile;

    /**
     * 联系人邮件
     */
    private String contactEmail;

    /**
     * 操作人
     */
    private String operator;

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
     * @return 父订单号
     */
    public String getParentOrderNo() {
        return parentOrderNo;
    }

    /**
     * @param parentOrderNo 父订单号
     */
    public void setParentOrderNo(String parentOrderNo) {
        this.parentOrderNo = parentOrderNo == null ? null : parentOrderNo.trim();
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
     * @return 票号
     */
    public String getTicketNo() {
        return ticketNo;
    }

    /**
     * @param ticketNo 票号
     */
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo == null ? null : ticketNo.trim();
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
     * @return 主飞航班
     */
    public String getActFlightNum() {
        return actFlightNum;
    }

    /**
     * @param actFlightNum 主飞航班
     */
    public void setActFlightNum(String actFlightNum) {
        this.actFlightNum = actFlightNum == null ? null : actFlightNum.trim();
    }

    /**
     * @return 航空公司编号
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * @param carrierCode 航空公司编号
     */
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode == null ? null : carrierCode.trim();
    }

    /**
     * @return 航空公司名称
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * @param carrierName 航空公司名称
     */
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName == null ? null : carrierName.trim();
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
     * @return 起飞机场名称
     */
    public String getDeptAirportName() {
        return deptAirportName;
    }

    /**
     * @param deptAirportName 起飞机场名称
     */
    public void setDeptAirportName(String deptAirportName) {
        this.deptAirportName = deptAirportName == null ? null : deptAirportName.trim();
    }

    /**
     * @return 到达机场名称
     */
    public String getArriAirportName() {
        return arriAirportName;
    }

    /**
     * @param arriAirportName 到达机场名称
     */
    public void setArriAirportName(String arriAirportName) {
        this.arriAirportName = arriAirportName == null ? null : arriAirportName.trim();
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
     * @return 到达时间
     */
    public String getArriTime() {
        return arriTime;
    }

    /**
     * @param arriTime 到达时间
     */
    public void setArriTime(String arriTime) {
        this.arriTime = arriTime == null ? null : arriTime.trim();
    }

    /**
     * @return 退票原因编号
     */
    public Integer getReteunCode() {
        return reteunCode;
    }

    /**
     * @param reteunCode 退票原因编号
     */
    public void setReteunCode(Integer reteunCode) {
        this.reteunCode = reteunCode;
    }

    /**
     * @return 是否可退（1-不可退，2-可退）
     */
    public Integer getHasDisabled() {
        return hasDisabled;
    }

    /**
     * @param hasDisabled 是否可退（1-不可退，2-可退）
     */
    public void setHasDisabled(Integer hasDisabled) {
        this.hasDisabled = hasDisabled;
    }

    /**
     * @return 不可退原因
     */
    public String getDisableReason() {
        return disableReason;
    }

    /**
     * @param disableReason 不可退原因
     */
    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason == null ? null : disableReason.trim();
    }

    /**
     * @return 退票状态
     */
    public Integer getReturnStatus() {
        return returnStatus;
    }

    /**
     * @param returnStatus 退票状态
     */
    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    /**
     * @return 退票时间
     */
    public String getReturnTime() {
        return returnTime;
    }

    /**
     * @param returnTime 退票时间
     */
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime == null ? null : returnTime.trim();
    }

    /**
     * @return 退票金额
     */
    public Integer getReturnFee() {
        return returnFee;
    }

    /**
     * @param returnFee 退票金额
     */
    public void setReturnFee(Integer returnFee) {
        this.returnFee = returnFee;
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
     * @return 联系人邮件
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * @param contactEmail 联系人邮件
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    /**
     * @return 操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator 操作人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
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