package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class InternationalOrder implements Serializable {
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
     * 票号
     */
    private String ticketNo;

    /**
     * 报价唯一标识
     */
    private String packName;

    /**
     * 航班号
     */
    private String goFlightNum;

    /**
     * 主飞航班
     */
    private String goActFlightNum;

    /**
     * 飞行时间
     */
    private String goFlightTime;

    /**
     * 航空公司编号
     */
    private String goCarrierCode;

    /**
     * 航空公司名称
     */
    private String goCarrierName;

    /**
     * 经停次数
     */
    private Integer goStopCnt;

    /**
     * 仓位
     */
    private String goCabin;

    /**
     * 出发城市
     */
    private String goDeptCity;

    /**
     * 到达城市
     */
    private String goArriCity;

    /**
     * 起飞机场编号
     */
    private String goDeptAirportCode;

    /**
     * 到达机场编号
     */
    private String goArriAirportCode;

    /**
     * 起飞机场名称
     */
    private String goDeptAirportName;

    /**
     * 到达机场名称
     */
    private String goArriAirportName;

    /**
     * 起飞机场航站楼
     */
    private String goDeptTerminal;

    /**
     * 到达机场航站楼
     */
    private String goArriTerminal;

    /**
     * 出发日期
     */
    private String goDeptDate;

    /**
     * 出发时间
     */
    private String goDeptTime;

    /**
     * 到达时间
     */
    private String goArriTime;

    /**
     * 航班号
     */
    private String backFlightNum;

    /**
     * 主飞航班
     */
    private String backActFlightNum;

    /**
     * 飞行时间
     */
    private String backFlightTime;

    /**
     * 航空公司编号
     */
    private String backCarrierCode;

    /**
     * 航空公司名称
     */
    private String backCarrierName;

    /**
     * 经停次数
     */
    private Integer backStopCnt;

    /**
     * 仓位
     */
    private String backCabin;

    /**
     * 出发城市
     */
    private String backDeptCity;

    /**
     * 到达城市
     */
    private String backArriCity;

    /**
     * 起飞机场编号
     */
    private String backDeptAirportCode;

    /**
     * 到达机场编号
     */
    private String backArriAirportCode;

    /**
     * 起飞机场名称
     */
    private String backDeptAirportName;

    /**
     * 到达机场名称
     */
    private String backArriAirportName;

    /**
     * 起飞机场航站楼
     */
    private String backDeptTerminal;

    /**
     * 到达机场航站楼
     */
    private String backArriTerminal;

    /**
     * 出发日期
     */
    private String backDeptDate;

    /**
     * 出发时间
     */
    private String backDeptTime;

    /**
     * 到达时间
     */
    private String backArriTime;

    /**
     * 退票费用
     */
    private Integer returnFee;

    /**
     * 退票费用说明
     */
    private String returnText;

    /**
     * 改签费用
     */
    private Integer changeFee;

    /**
     * 改签费用说明
     */
    private String changeText;

    /**
     * 支付流水号
     */
    private String payId;

    /**
     * 支付金额
     */
    private Integer payAmount;

    /**
     * 支付状态(0:等待支付,1:支付成功等待出票)
     */
    private Integer payStatus;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 支付时限
     */
    private String payDeadline;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 优惠券金额
     */
    private Integer couponMoney;

    /**
     * 加价金额
     */
    private Integer addMoney;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 国家区位码
     */
    private String contactNum;

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
     * 是否显示(0:不显示,1:显示)
     */
    private Integer hasShow;

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
     * @return 报价唯一标识
     */
    public String getPackName() {
        return packName;
    }

    /**
     * @param packName 报价唯一标识
     */
    public void setPackName(String packName) {
        this.packName = packName == null ? null : packName.trim();
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
     * @return 主飞航班
     */
    public String getGoActFlightNum() {
        return goActFlightNum;
    }

    /**
     * @param goActFlightNum 主飞航班
     */
    public void setGoActFlightNum(String goActFlightNum) {
        this.goActFlightNum = goActFlightNum == null ? null : goActFlightNum.trim();
    }

    /**
     * @return 飞行时间
     */
    public String getGoFlightTime() {
        return goFlightTime;
    }

    /**
     * @param goFlightTime 飞行时间
     */
    public void setGoFlightTime(String goFlightTime) {
        this.goFlightTime = goFlightTime == null ? null : goFlightTime.trim();
    }

    /**
     * @return 航空公司编号
     */
    public String getGoCarrierCode() {
        return goCarrierCode;
    }

    /**
     * @param goCarrierCode 航空公司编号
     */
    public void setGoCarrierCode(String goCarrierCode) {
        this.goCarrierCode = goCarrierCode == null ? null : goCarrierCode.trim();
    }

    /**
     * @return 航空公司名称
     */
    public String getGoCarrierName() {
        return goCarrierName;
    }

    /**
     * @param goCarrierName 航空公司名称
     */
    public void setGoCarrierName(String goCarrierName) {
        this.goCarrierName = goCarrierName == null ? null : goCarrierName.trim();
    }

    /**
     * @return 经停次数
     */
    public Integer getGoStopCnt() {
        return goStopCnt;
    }

    /**
     * @param goStopCnt 经停次数
     */
    public void setGoStopCnt(Integer goStopCnt) {
        this.goStopCnt = goStopCnt;
    }

    /**
     * @return 仓位
     */
    public String getGoCabin() {
        return goCabin;
    }

    /**
     * @param goCabin 仓位
     */
    public void setGoCabin(String goCabin) {
        this.goCabin = goCabin == null ? null : goCabin.trim();
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
     * @return 起飞机场编号
     */
    public String getGoDeptAirportCode() {
        return goDeptAirportCode;
    }

    /**
     * @param goDeptAirportCode 起飞机场编号
     */
    public void setGoDeptAirportCode(String goDeptAirportCode) {
        this.goDeptAirportCode = goDeptAirportCode == null ? null : goDeptAirportCode.trim();
    }

    /**
     * @return 到达机场编号
     */
    public String getGoArriAirportCode() {
        return goArriAirportCode;
    }

    /**
     * @param goArriAirportCode 到达机场编号
     */
    public void setGoArriAirportCode(String goArriAirportCode) {
        this.goArriAirportCode = goArriAirportCode == null ? null : goArriAirportCode.trim();
    }

    /**
     * @return 起飞机场名称
     */
    public String getGoDeptAirportName() {
        return goDeptAirportName;
    }

    /**
     * @param goDeptAirportName 起飞机场名称
     */
    public void setGoDeptAirportName(String goDeptAirportName) {
        this.goDeptAirportName = goDeptAirportName == null ? null : goDeptAirportName.trim();
    }

    /**
     * @return 到达机场名称
     */
    public String getGoArriAirportName() {
        return goArriAirportName;
    }

    /**
     * @param goArriAirportName 到达机场名称
     */
    public void setGoArriAirportName(String goArriAirportName) {
        this.goArriAirportName = goArriAirportName == null ? null : goArriAirportName.trim();
    }

    /**
     * @return 起飞机场航站楼
     */
    public String getGoDeptTerminal() {
        return goDeptTerminal;
    }

    /**
     * @param goDeptTerminal 起飞机场航站楼
     */
    public void setGoDeptTerminal(String goDeptTerminal) {
        this.goDeptTerminal = goDeptTerminal == null ? null : goDeptTerminal.trim();
    }

    /**
     * @return 到达机场航站楼
     */
    public String getGoArriTerminal() {
        return goArriTerminal;
    }

    /**
     * @param goArriTerminal 到达机场航站楼
     */
    public void setGoArriTerminal(String goArriTerminal) {
        this.goArriTerminal = goArriTerminal == null ? null : goArriTerminal.trim();
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
     * @return 到达时间
     */
    public String getGoArriTime() {
        return goArriTime;
    }

    /**
     * @param goArriTime 到达时间
     */
    public void setGoArriTime(String goArriTime) {
        this.goArriTime = goArriTime == null ? null : goArriTime.trim();
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
     * @return 主飞航班
     */
    public String getBackActFlightNum() {
        return backActFlightNum;
    }

    /**
     * @param backActFlightNum 主飞航班
     */
    public void setBackActFlightNum(String backActFlightNum) {
        this.backActFlightNum = backActFlightNum == null ? null : backActFlightNum.trim();
    }

    /**
     * @return 飞行时间
     */
    public String getBackFlightTime() {
        return backFlightTime;
    }

    /**
     * @param backFlightTime 飞行时间
     */
    public void setBackFlightTime(String backFlightTime) {
        this.backFlightTime = backFlightTime == null ? null : backFlightTime.trim();
    }

    /**
     * @return 航空公司编号
     */
    public String getBackCarrierCode() {
        return backCarrierCode;
    }

    /**
     * @param backCarrierCode 航空公司编号
     */
    public void setBackCarrierCode(String backCarrierCode) {
        this.backCarrierCode = backCarrierCode == null ? null : backCarrierCode.trim();
    }

    /**
     * @return 航空公司名称
     */
    public String getBackCarrierName() {
        return backCarrierName;
    }

    /**
     * @param backCarrierName 航空公司名称
     */
    public void setBackCarrierName(String backCarrierName) {
        this.backCarrierName = backCarrierName == null ? null : backCarrierName.trim();
    }

    /**
     * @return 经停次数
     */
    public Integer getBackStopCnt() {
        return backStopCnt;
    }

    /**
     * @param backStopCnt 经停次数
     */
    public void setBackStopCnt(Integer backStopCnt) {
        this.backStopCnt = backStopCnt;
    }

    /**
     * @return 仓位
     */
    public String getBackCabin() {
        return backCabin;
    }

    /**
     * @param backCabin 仓位
     */
    public void setBackCabin(String backCabin) {
        this.backCabin = backCabin == null ? null : backCabin.trim();
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
     * @return 起飞机场编号
     */
    public String getBackDeptAirportCode() {
        return backDeptAirportCode;
    }

    /**
     * @param backDeptAirportCode 起飞机场编号
     */
    public void setBackDeptAirportCode(String backDeptAirportCode) {
        this.backDeptAirportCode = backDeptAirportCode == null ? null : backDeptAirportCode.trim();
    }

    /**
     * @return 到达机场编号
     */
    public String getBackArriAirportCode() {
        return backArriAirportCode;
    }

    /**
     * @param backArriAirportCode 到达机场编号
     */
    public void setBackArriAirportCode(String backArriAirportCode) {
        this.backArriAirportCode = backArriAirportCode == null ? null : backArriAirportCode.trim();
    }

    /**
     * @return 起飞机场名称
     */
    public String getBackDeptAirportName() {
        return backDeptAirportName;
    }

    /**
     * @param backDeptAirportName 起飞机场名称
     */
    public void setBackDeptAirportName(String backDeptAirportName) {
        this.backDeptAirportName = backDeptAirportName == null ? null : backDeptAirportName.trim();
    }

    /**
     * @return 到达机场名称
     */
    public String getBackArriAirportName() {
        return backArriAirportName;
    }

    /**
     * @param backArriAirportName 到达机场名称
     */
    public void setBackArriAirportName(String backArriAirportName) {
        this.backArriAirportName = backArriAirportName == null ? null : backArriAirportName.trim();
    }

    /**
     * @return 起飞机场航站楼
     */
    public String getBackDeptTerminal() {
        return backDeptTerminal;
    }

    /**
     * @param backDeptTerminal 起飞机场航站楼
     */
    public void setBackDeptTerminal(String backDeptTerminal) {
        this.backDeptTerminal = backDeptTerminal == null ? null : backDeptTerminal.trim();
    }

    /**
     * @return 到达机场航站楼
     */
    public String getBackArriTerminal() {
        return backArriTerminal;
    }

    /**
     * @param backArriTerminal 到达机场航站楼
     */
    public void setBackArriTerminal(String backArriTerminal) {
        this.backArriTerminal = backArriTerminal == null ? null : backArriTerminal.trim();
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
     * @return 到达时间
     */
    public String getBackArriTime() {
        return backArriTime;
    }

    /**
     * @param backArriTime 到达时间
     */
    public void setBackArriTime(String backArriTime) {
        this.backArriTime = backArriTime == null ? null : backArriTime.trim();
    }

    /**
     * @return 退票费用
     */
    public Integer getReturnFee() {
        return returnFee;
    }

    /**
     * @param returnFee 退票费用
     */
    public void setReturnFee(Integer returnFee) {
        this.returnFee = returnFee;
    }

    /**
     * @return 退票费用说明
     */
    public String getReturnText() {
        return returnText;
    }

    /**
     * @param returnText 退票费用说明
     */
    public void setReturnText(String returnText) {
        this.returnText = returnText == null ? null : returnText.trim();
    }

    /**
     * @return 改签费用
     */
    public Integer getChangeFee() {
        return changeFee;
    }

    /**
     * @param changeFee 改签费用
     */
    public void setChangeFee(Integer changeFee) {
        this.changeFee = changeFee;
    }

    /**
     * @return 改签费用说明
     */
    public String getChangeText() {
        return changeText;
    }

    /**
     * @param changeText 改签费用说明
     */
    public void setChangeText(String changeText) {
        this.changeText = changeText == null ? null : changeText.trim();
    }

    /**
     * @return 支付流水号
     */
    public String getPayId() {
        return payId;
    }

    /**
     * @param payId 支付流水号
     */
    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
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
     * @return 支付状态(0:等待支付,1:支付成功等待出票)
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * @param payStatus 支付状态(0:等待支付,1:支付成功等待出票)
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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
     * @return 支付时限
     */
    public String getPayDeadline() {
        return payDeadline;
    }

    /**
     * @param payDeadline 支付时限
     */
    public void setPayDeadline(String payDeadline) {
        this.payDeadline = payDeadline == null ? null : payDeadline.trim();
    }

    /**
     * @return 优惠券id
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * @param couponId 优惠券id
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * @return 优惠券金额
     */
    public Integer getCouponMoney() {
        return couponMoney;
    }

    /**
     * @param couponMoney 优惠券金额
     */
    public void setCouponMoney(Integer couponMoney) {
        this.couponMoney = couponMoney;
    }

    /**
     * @return 加价金额
     */
    public Integer getAddMoney() {
        return addMoney;
    }

    /**
     * @param addMoney 加价金额
     */
    public void setAddMoney(Integer addMoney) {
        this.addMoney = addMoney;
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
     * @return 国家区位码
     */
    public String getContactNum() {
        return contactNum;
    }

    /**
     * @param contactNum 国家区位码
     */
    public void setContactNum(String contactNum) {
        this.contactNum = contactNum == null ? null : contactNum.trim();
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
     * @return 是否显示(0:不显示,1:显示)
     */
    public Integer getHasShow() {
        return hasShow;
    }

    /**
     * @param hasShow 是否显示(0:不显示,1:显示)
     */
    public void setHasShow(Integer hasShow) {
        this.hasShow = hasShow;
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