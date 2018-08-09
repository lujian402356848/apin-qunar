package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.payValidate.PayValidateParam;
import com.apin.qunar.order.service.national.PayValidateService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Service
public class PayValidateServiceImpl extends ApiService<PayValidateParam, ApiResult<String>> implements PayValidateService {

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.payValidate";
    }

    @Override
    protected TypeReference<ApiResult<String>> getTypeReference() {
        return new TypeReference<ApiResult<String>>() {
        };
    }

    @Override
    public ApiResult<String> validate(final PayValidateParam payValidateParam) {
        ApiResult<String> apiResult = execute(payValidateParam);
        return apiResult == null ? ApiResult.fail() : apiResult;
    }
}
