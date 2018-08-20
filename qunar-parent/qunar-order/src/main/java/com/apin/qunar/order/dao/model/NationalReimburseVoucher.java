package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class NationalReimburseVoucher implements Serializable {
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
     * 出发城市
     */
    private String deptCity;

    /**
     * 到达城市
     */
    private String arriCity;

    /**
     * 航班号
     */
    private String flightNum;

    /**
     * 出发日期
     */
    private String deptDate;

    /**
     * 凭据号(行程单号/票号)
     */
    private String voucherNo;

    /**
     * 凭据类型(1:行程单,2:发票)
     */
    private Integer voucherType;

    /**
     * 快递号
     */
    private String invoiceNo;

    /**
     * 报销单类型(1:行程单差额发票)
     */
    private Integer reimburseType;

    /**
     * 配送方式(1:快递)
     */
    private Integer distributionType;

    /**
     * 配送金额(元为单位)
     */
    private Integer distributionAmount;

    /**
     * 发票抬头类型(1:企业,2:个人)
     */
    private Integer invoiceTitleType;

    /**
     * 发票抬头内容
     */
    private String invoiceTitleContent;

    /**
     * 纳税人编号
     */
    private String taxpayerNo;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人手机号
     */
    private String receiverMobileNo;

    /**
     * 收件人地址
     */
    private String receiveAddress;

    /**
     * 编辑人
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
     * @return 凭据号(行程单号/票号)
     */
    public String getVoucherNo() {
        return voucherNo;
    }

    /**
     * @param voucherNo 凭据号(行程单号/票号)
     */
    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo == null ? null : voucherNo.trim();
    }

    /**
     * @return 凭据类型(1:行程单,2:发票)
     */
    public Integer getVoucherType() {
        return voucherType;
    }

    /**
     * @param voucherType 凭据类型(1:行程单,2:发票)
     */
    public void setVoucherType(Integer voucherType) {
        this.voucherType = voucherType;
    }

    /**
     * @return 快递号
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo 快递号
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    /**
     * @return 报销单类型(1:行程单差额发票)
     */
    public Integer getReimburseType() {
        return reimburseType;
    }

    /**
     * @param reimburseType 报销单类型(1:行程单差额发票)
     */
    public void setReimburseType(Integer reimburseType) {
        this.reimburseType = reimburseType;
    }

    /**
     * @return 配送方式(1:快递)
     */
    public Integer getDistributionType() {
        return distributionType;
    }

    /**
     * @param distributionType 配送方式(1:快递)
     */
    public void setDistributionType(Integer distributionType) {
        this.distributionType = distributionType;
    }

    /**
     * @return 配送金额(元为单位)
     */
    public Integer getDistributionAmount() {
        return distributionAmount;
    }

    /**
     * @param distributionAmount 配送金额(元为单位)
     */
    public void setDistributionAmount(Integer distributionAmount) {
        this.distributionAmount = distributionAmount;
    }

    /**
     * @return 发票抬头类型(1:企业,2:个人)
     */
    public Integer getInvoiceTitleType() {
        return invoiceTitleType;
    }

    /**
     * @param invoiceTitleType 发票抬头类型(1:企业,2:个人)
     */
    public void setInvoiceTitleType(Integer invoiceTitleType) {
        this.invoiceTitleType = invoiceTitleType;
    }

    /**
     * @return 发票抬头内容
     */
    public String getInvoiceTitleContent() {
        return invoiceTitleContent;
    }

    /**
     * @param invoiceTitleContent 发票抬头内容
     */
    public void setInvoiceTitleContent(String invoiceTitleContent) {
        this.invoiceTitleContent = invoiceTitleContent == null ? null : invoiceTitleContent.trim();
    }

    /**
     * @return 纳税人编号
     */
    public String getTaxpayerNo() {
        return taxpayerNo;
    }

    /**
     * @param taxpayerNo 纳税人编号
     */
    public void setTaxpayerNo(String taxpayerNo) {
        this.taxpayerNo = taxpayerNo == null ? null : taxpayerNo.trim();
    }

    /**
     * @return 收件人姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName 收件人姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * @return 收件人手机号
     */
    public String getReceiverMobileNo() {
        return receiverMobileNo;
    }

    /**
     * @param receiverMobileNo 收件人手机号
     */
    public void setReceiverMobileNo(String receiverMobileNo) {
        this.receiverMobileNo = receiverMobileNo == null ? null : receiverMobileNo.trim();
    }

    /**
     * @return 收件人地址
     */
    public String getReceiveAddress() {
        return receiveAddress;
    }

    /**
     * @param receiveAddress 收件人地址
     */
    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    /**
     * @return 编辑人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator 编辑人
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