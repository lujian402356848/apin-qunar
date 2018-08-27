package com.apin.qunar.app.basic.controller;

import com.apin.qunar.app.basic.request.SearchCouponListRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.domain.coupon.CouponVO;
import com.apin.qunar.basic.service.CouponService;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class CouponController {
    @Resource
    private CouponService couponService;

    @PostMapping(value = "/coupon/list")
    public GeneralResultMap searchCouponList(@RequestBody SearchCouponListRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        Map<String, Object> data = new HashMap<>();
        if (request.getOffset() == null || request.getOffset() < 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        List<CouponVO> couponVOS = couponService.queryBy(request.getAccount(), request.getStatus(), request.getOffset(), request.getLimit());
        try {
            data.put("couponList", couponVOS);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询优惠券列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }
}
