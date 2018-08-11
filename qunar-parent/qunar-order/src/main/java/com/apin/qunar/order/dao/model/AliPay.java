package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class AliPay implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private String id;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单类型(1:普通订单,2:改签订单)
     */
    private Integer orderType;

    /**
     * 是否为国内订单
     */
    private Integer hasInlandOrder;

    /**
     * 支付宝交易号
     */
    private String alipayTradeNo;

    /**
     * 支付金额
     */
    private Integer payAmount;

    /**
     * 支付宝支付状态(0:未支付,1:支付中,2:支付成功)
     */
    private Integer aliPayStatus;

    /**
     * 支付宝支付时间
     */
    private String aliPayTime;

    /**
     * 去哪儿支付状态(0:未支付,1:支付失败,2:支付成功)
     */
    private Integer qunarPayStatus;

    /**
     * 去哪儿支付时间
     */
    private String qunarPayTime;

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
    public String getId() {
        return id;
    }

    /**
     * @param id 唯一标识
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
     * @return 订单类型(1:普通订单,2:改签订单)
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * @param orderType 订单类型(1:普通订单,2:改签订单)
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * @return 是否为国内订单
     */
    public Integer getHasInlandOrder() {
        return hasInlandOrder;
    }

    /**
     * @param hasInlandOrder 是否为国内订单
     */
    public void setHasInlandOrder(Integer hasInlandOrder) {
        this.hasInlandOrder = hasInlandOrder;
    }

    /**
     * @return 支付宝交易号
     */
    public String getAlipayTradeNo() {
        return alipayTradeNo;
    }

    /**
     * @param alipayTradeNo 支付宝交易号
     */
    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo == null ? null : alipayTradeNo.trim();
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
     * @return 支付宝支付状态(0:未支付,1:支付中,2:支付成功)
     */
    public Integer getAliPayStatus() {
        return aliPayStatus;
    }

    /**
     * @param aliPayStatus 支付宝支付状态(0:未支付,1:支付中,2:支付成功)
     */
    public void setAliPayStatus(Integer aliPayStatus) {
        this.aliPayStatus = aliPayStatus;
    }

    /**
     * @return 支付宝支付时间
     */
    public String getAliPayTime() {
        return aliPayTime;
    }

    /**
     * @param aliPayTime 支付宝支付时间
     */
    public void setAliPayTime(String aliPayTime) {
        this.aliPayTime = aliPayTime == null ? null : aliPayTime.trim();
    }

    /**
     * @return 去哪儿支付状态(0:未支付,1:支付失败,2:支付成功)
     */
    public Integer getQunarPayStatus() {
        return qunarPayStatus;
    }

    /**
     * @param qunarPayStatus 去哪儿支付状态(0:未支付,1:支付失败,2:支付成功)
     */
    public void setQunarPayStatus(Integer qunarPayStatus) {
        this.qunarPayStatus = qunarPayStatus;
    }

    /**
     * @return 去哪儿支付时间
     */
    public String getQunarPayTime() {
        return qunarPayTime;
    }

    /**
     * @param qunarPayTime 去哪儿支付时间
     */
    public void setQunarPayTime(String qunarPayTime) {
        this.qunarPayTime = qunarPayTime == null ? null : qunarPayTime.trim();
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