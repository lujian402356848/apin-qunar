package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class NationalReturnPassenger implements Serializable {
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
     * 乘客名称
     */
    private String name;

    /**
     * 出生年月(yyyy-MM-dd)
     */
    private String birthday;

    /**
     * 性别(0:女,1:男)
     */
    private Integer gender;

    /**
     * 卡类型(NI:身份证)
     */
    private String cardType;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 是否申请退款成功(0:失败,1:成功)
     */
    private Integer hasRefund;

    /**
     * 申请退款失败原因
     */
    private String refundReason;

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
     * @return 乘客名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 乘客名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return 出生年月(yyyy-MM-dd)
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday 出生年月(yyyy-MM-dd)
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * @return 性别(0:女,1:男)
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender 性别(0:女,1:男)
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * @return 卡类型(NI:身份证)
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * @param cardType 卡类型(NI:身份证)
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * @return 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * @return 是否申请退款成功(0:失败,1:成功)
     */
    public Integer getHasRefund() {
        return hasRefund;
    }

    /**
     * @param hasRefund 是否申请退款成功(0:失败,1:成功)
     */
    public void setHasRefund(Integer hasRefund) {
        this.hasRefund = hasRefund;
    }

    /**
     * @return 申请退款失败原因
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * @param refundReason 申请退款失败原因
     */
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
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