package com.apin.qunar.order.dao.model;

import java.io.Serializable;

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
}