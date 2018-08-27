package com.apin.qunar.basic.dao.impl;

import com.apin.qunar.basic.dao.mapper.CouponExtMapper;
import com.apin.qunar.basic.dao.mapper.CouponMapper;
import com.apin.qunar.basic.dao.model.Coupon;
import com.apin.qunar.basic.domain.coupon.CouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponDaoImpl {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponExtMapper couponExtMapper;

    public List<CouponVO> queryBy(String account, Integer status, Integer offset, Integer limit) {
        return couponExtMapper.queryBy(account, status, offset, limit);
    }

    public boolean insert(Coupon coupon) {
        return couponMapper.insert(coupon) > 0;
    }

    public boolean updateStatus(Long id, int status) {
        return couponExtMapper.updateStatus(id, status) > 0;
    }
}
