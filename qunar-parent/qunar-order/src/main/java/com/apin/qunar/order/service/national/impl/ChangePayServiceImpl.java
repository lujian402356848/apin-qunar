package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changePay.ChangePayParam;
import com.apin.qunar.order.domain.national.changePay.ChangePayResultVO;
import com.apin.qunar.order.service.national.ChangePayService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

/**
 * @outhor lujian
 * @create 2018-07-02 18:49
 */
@Service
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
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), ChangePayResultVO.class));
    }
}