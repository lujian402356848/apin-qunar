package com.apin.qunar.basic.service;

import com.apin.qunar.basic.domain.coupon.CouponVO;

import java.util.List;

public interface CouponService {
    List<CouponVO> queryBy(String account, Integer status, Integer offset, Integer limit);
}
