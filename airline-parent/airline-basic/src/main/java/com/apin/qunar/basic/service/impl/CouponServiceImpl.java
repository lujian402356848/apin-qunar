package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.dao.impl.CouponDaoImpl;
import com.apin.qunar.basic.domain.coupon.CouponVO;
import com.apin.qunar.basic.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponDaoImpl couponDao;

    @Override
    public List<CouponVO> queryBy(String account, Integer status, Integer offset, Integer limit) {
        return couponDao.queryBy(account, status, offset, limit);
    }
}
