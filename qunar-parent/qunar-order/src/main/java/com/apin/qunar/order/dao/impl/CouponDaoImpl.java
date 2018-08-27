package com.apin.qunar.order.dao.impl;

import com.apin.qunar.order.dao.mapper.CouponExtMapper;
import com.apin.qunar.order.dao.mapper.CouponMapper;
import com.apin.qunar.order.dao.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponDaoImpl {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponExtMapper couponExtMapper;

    public boolean insert(Coupon coupon) {
        return couponMapper.insert(coupon) > 0;
    }

    public boolean updateStatus(Long id, int status) {
        return couponExtMapper.updateStatus(id, status) > 0;
    }
}
