package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class GroupOrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

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
     * 到达机场名称
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
     * @return 到达机场名称
     */
    public String getArriAirportCode() {
        return arriAirportCode;
    }

    /**
     * @param arriAirportCode 到达机场名称
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