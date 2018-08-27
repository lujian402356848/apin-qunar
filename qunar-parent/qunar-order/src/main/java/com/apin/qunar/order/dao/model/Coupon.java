package com.apin.qunar.order.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Coupon implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 优惠券id
     */
    private Long id;

    /**
     * 账户id
     */
    private String account;

    /**
     * 优惠券金额
     */
    private Integer couponMoney;

    /**
     * 优惠券类型(1:首次登陆立减)
     */
    private Integer couponType;

    /**
     * 优惠券状态(0:未使用,1:已使用,2:已过期)
     */
    private Integer couponStatus;

    /**
     * 可使用的最小金额
     */
    private Integer minAmount;

    /**
     * 可使用的最大金额
     */
    private Integer maxAmount;

    /**
     * 可使用的开始时间
     */
    private Date useStartDate;

    /**
     * 可使用的结束时间
     */
    private Date useEndDate;

    /**
     * @return 优惠券id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 优惠券id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 账户id
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account 账户id
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
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
     * @return 优惠券类型(1:首次登陆立减)
     */
    public Integer getCouponType() {
        return couponType;
    }

    /**
     * @param couponType 优惠券类型(1:首次登陆立减)
     */
    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    /**
     * @return 优惠券状态(0:未使用,1:已使用,2:已过期)
     */
    public Integer getCouponStatus() {
        return couponStatus;
    }

    /**
     * @param couponStatus 优惠券状态(0:未使用,1:已使用,2:已过期)
     */
    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    /**
     * @return 可使用的最小金额
     */
    public Integer getMinAmount() {
        return minAmount;
    }

    /**
     * @param minAmount 可使用的最小金额
     */
    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * @return 可使用的最大金额
     */
    public Integer getMaxAmount() {
        return maxAmount;
    }

    /**
     * @param maxAmount 可使用的最大金额
     */
    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * @return 可使用的开始时间
     */
    public Date getUseStartDate() {
        return useStartDate;
    }

    /**
     * @param useStartDate 可使用的开始时间
     */
    public void setUseStartDate(Date useStartDate) {
        this.useStartDate = useStartDate;
    }

    /**
     * @return 可使用的结束时间
     */
    public Date getUseEndDate() {
        return useEndDate;
    }

    /**
     * @param useEndDate 可使用的结束时间
     */
    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }
}