package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class NationalOrder implements Serializable {
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
     * 订单关系
     */
    private String orderRelationNo;

    /**
     * 票号
     */
    private String ticketNo;

    /**
     * 创建订单成功后返回的域名
     */
    private String clientSite;

    /**
     * 航班号
     */
    private String flightNum;

    /**
     * 主飞航班
     */
    private String actFlightNum;

    /**
     * 飞行时间
     */
    private String flightTime;

    /**
     * 航空公司编号
     */
    private String carrierCode;

    /**
     * 航空公司名称
     */
    private String carrierName;

    /**
     * 经停次数
     */
    private Integer stopCnt;

    /**
     * 仓位
     */
    private String cabin;

    /**
     * 产品tag
     */
    private String tag;

    /**
     * 出发城市
     */
    private String deptCity;

    /**
     * 到达城市
     */
    private String arriCity;

    /**
     * 起飞机场编号
     */
    private String deptAirportCode;

    /**
     * 到达机场编号
     */
    private String arriAirportCode;

    /**
     * 起飞机场名称
     */
    private String deptAirportName;

    /**
     * 到达机场名称
     */
    private String arriAirportName;

    /**
     * 起飞机场航站楼
     */
    private String deptTerminal;

    /**
     * 到达机场航站楼
     */
    private String arriTerminal;

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
     * 燃油税
     */
    private Integer fuelTax;

    /**
     * 机场建设费
     */
    private Integer constructionFee;

    /**
     * 退票费用
     */
    private Integer returnFee;

    /**
     * 退票费用说明
     */
    private String returnText;

    /**
     * 改期费用
     */
    private Integer changeFee;

    /**
     * 改期费用说明
     */
    private String changeText;

    /**
     * 票面价
     */
    private Integer printPrice;

    /**
     * 1表示共享,0表示不共享
     */
    private Integer codeShare;

    /**
     * 公布运价
     */
    private Integer publishPrice;

    /**
     * 支付流水号
     */
    private String payId;

    /**
     * 支付的订单id
     */
    private String payOrderId;

    /**
     * 支付类型(0:内部支付,1:支付宝,2:微信)
     */
    private Integer payType;

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
     * @return 订单关系
     */
    public String getOrderRelationNo() {
        return orderRelationNo;
    }

    /**
     * @param orderRelationNo 订单关系
     */
    public void setOrderRelationNo(String orderRelationNo) {
        this.orderRelationNo = orderRelationNo == null ? null : orderRelationNo.trim();
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
     * @return 创建订单成功后返回的域名
     */
    public String getClientSite() {
        return clientSite;
    }

    /**
     * @param clientSite 创建订单成功后返回的域名
     */
    public void setClientSite(String clientSite) {
        this.clientSite = clientSite == null ? null : clientSite.trim();
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
     * @return 飞行时间
     */
    public String getFlightTime() {
        return flightTime;
    }

    /**
     * @param flightTime 飞行时间
     */
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime == null ? null : flightTime.trim();
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
     * @return 经停次数
     */
    public Integer getStopCnt() {
        return stopCnt;
    }

    /**
     * @param stopCnt 经停次数
     */
    public void setStopCnt(Integer stopCnt) {
        this.stopCnt = stopCnt;
    }

    /**
     * @return 仓位
     */
    public String getCabin() {
        return cabin;
    }

    /**
     * @param cabin 仓位
     */
    public void setCabin(String cabin) {
        this.cabin = cabin == null ? null : cabin.trim();
    }

    /**
     * @return 产品tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag 产品tag
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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
     * @return 起飞机场编号
     */
    public String getDeptAirportCode() {
        return deptAirportCode;
    }

    /**
     * @param deptAirportCode 起飞机场编号
     */
    public void setDeptAirportCode(String deptAirportCode) {
        this.deptAirportCode = deptAirportCode == null ? null : deptAirportCode.trim();
    }

    /**
     * @return 到达机场编号
     */
    public String getArriAirportCode() {
        return arriAirportCode;
    }

    /**
     * @param arriAirportCode 到达机场编号
     */
    public void setArriAirportCode(String arriAirportCode) {
        this.arriAirportCode = arriAirportCode == null ? null : arriAirportCode.trim();
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
     * @return 起飞机场航站楼
     */
    public String getDeptTerminal() {
        return deptTerminal;
    }

    /**
     * @param deptTerminal 起飞机场航站楼
     */
    public void setDeptTerminal(String deptTerminal) {
        this.deptTerminal = deptTerminal == null ? null : deptTerminal.trim();
    }

    /**
     * @return 到达机场航站楼
     */
    public String getArriTerminal() {
        return arriTerminal;
    }

    /**
     * @param arriTerminal 到达机场航站楼
     */
    public void setArriTerminal(String arriTerminal) {
        this.arriTerminal = arriTerminal == null ? null : arriTerminal.trim();
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
     * @return 燃油税
     */
    public Integer getFuelTax() {
        return fuelTax;
    }

    /**
     * @param fuelTax 燃油税
     */
    public void setFuelTax(Integer fuelTax) {
        this.fuelTax = fuelTax;
    }

    /**
     * @return 机场建设费
     */
    public Integer getConstructionFee() {
        return constructionFee;
    }

    /**
     * @param constructionFee 机场建设费
     */
    public void setConstructionFee(Integer constructionFee) {
        this.constructionFee = constructionFee;
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
     * @return 改期费用
     */
    public Integer getChangeFee() {
        return changeFee;
    }

    /**
     * @param changeFee 改期费用
     */
    public void setChangeFee(Integer changeFee) {
        this.changeFee = changeFee;
    }

    /**
     * @return 改期费用说明
     */
    public String getChangeText() {
        return changeText;
    }

    /**
     * @param changeText 改期费用说明
     */
    public void setChangeText(String changeText) {
        this.changeText = changeText == null ? null : changeText.trim();
    }

    /**
     * @return 票面价
     */
    public Integer getPrintPrice() {
        return printPrice;
    }

    /**
     * @param printPrice 票面价
     */
    public void setPrintPrice(Integer printPrice) {
        this.printPrice = printPrice;
    }

    /**
     * @return 1表示共享,0表示不共享
     */
    public Integer getCodeShare() {
        return codeShare;
    }

    /**
     * @param codeShare 1表示共享,0表示不共享
     */
    public void setCodeShare(Integer codeShare) {
        this.codeShare = codeShare;
    }

    /**
     * @return 公布运价
     */
    public Integer getPublishPrice() {
        return publishPrice;
    }

    /**
     * @param publishPrice 公布运价
     */
    public void setPublishPrice(Integer publishPrice) {
        this.publishPrice = publishPrice;
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
     * @return 支付的订单id
     */
    public String getPayOrderId() {
        return payOrderId;
    }

    /**
     * @param payOrderId 支付的订单id
     */
    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId == null ? null : payOrderId.trim();
    }

    /**
     * @return 支付类型(0:内部支付,1:支付宝,2:微信)
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * @param payType 支付类型(0:内部支付,1:支付宝,2:微信)
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
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