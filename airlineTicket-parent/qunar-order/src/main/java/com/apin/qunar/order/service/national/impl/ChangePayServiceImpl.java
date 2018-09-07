package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changePay.ChangePayParam;
import com.apin.qunar.order.domain.national.changePay.ChangePayResultVO;
import com.apin.qunar.order.service.national.ChangePayService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @outhor lujian
 * @create 2018-07-02 18:49
 */
@Service
@Slf4j
public class ChangePayServiceImpl extends ApiService<ChangePayParam, ApiResult<ChangePayResultVO>> implements ChangePayService {
    @Override
    protected String getTag() {
        return "flight.national.supply.sl.changePay";
    }

    @Override
    protected TypeReference<ApiResult<ChangePayResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<ChangePayResultVO>>() {
        };
    }

    @Override
    public ApiResult<ChangePayResultVO> changePay(final ChangePayParam changePayParam) {
        ApiResult<ChangePayResultVO> apiResult = execute(changePayParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("国内订单改签支付失败,params:{},原因:{}", JSON.toJSON(changePayParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), ChangePayResultVO.class));
    }
}