package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateParam;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateResultVO;
import com.apin.qunar.order.service.international.NtsPayValidateService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Service
public class NtsPayValidateServiceImpl extends NtsApiService<NtsPayValidateParam, ApiResult<NtsPayValidateResultVO>> implements NtsPayValidateService {

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.payValidate";
    }

    @Override
    protected TypeReference<ApiResult<NtsPayValidateResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsPayValidateResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsPayValidateResultVO> payValidate(final NtsPayValidateParam ntsPayValidateParam) {
        ApiResult<NtsPayValidateResultVO> apiResult = execute(ntsPayValidateParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), NtsPayValidateResultVO.class));
    }
}