package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class WechatPay implements Serializable {
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
     * 支付金额(元为单位)
     */
    private Integer payAmount;

    /**
     * 微信交易号
     */
    private String wechatTradeNo;

    /**
     * 微信支付状态(0:未支付,1:支付中,2:支付成功)
     */
    private Integer wechatPayStatus;

    /**
     * 微信支付时间
     */
    private String wechatPayTime;

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
     * @return 支付金额(元为单位)
     */
    public Integer getPayAmount() {
        return payAmount;
    }

    /**
     * @param payAmount 支付金额(元为单位)
     */
    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * @return 微信交易号
     */
    public String getWechatTradeNo() {
        return wechatTradeNo;
    }

    /**
     * @param wechatTradeNo 微信交易号
     */
    public void setWechatTradeNo(String wechatTradeNo) {
        this.wechatTradeNo = wechatTradeNo == null ? null : wechatTradeNo.trim();
    }

    /**
     * @return 微信支付状态(0:未支付,1:支付中,2:支付成功)
     */
    public Integer getWechatPayStatus() {
        return wechatPayStatus;
    }

    /**
     * @param wechatPayStatus 微信支付状态(0:未支付,1:支付中,2:支付成功)
     */
    public void setWechatPayStatus(Integer wechatPayStatus) {
        this.wechatPayStatus = wechatPayStatus;
    }

    /**
     * @return 微信支付时间
     */
    public String getWechatPayTime() {
        return wechatPayTime;
    }

    /**
     * @param wechatPayTime 微信支付时间
     */
    public void setWechatPayTime(String wechatPayTime) {
        this.wechatPayTime = wechatPayTime == null ? null : wechatPayTime.trim();
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