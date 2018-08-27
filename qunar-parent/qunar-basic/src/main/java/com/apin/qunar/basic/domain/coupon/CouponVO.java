package com.apin.qunar.basic.domain.coupon;

import lombok.Data;

import java.util.Date;

@Data
public class CouponVO {
    private Long id;
    private Integer couponMoney;
    private Integer couponType;
    private Integer couponStatus;
    private Date insertTime;
}
