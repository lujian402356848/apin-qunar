package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyResultVO;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyParam;
import com.apin.qunar.order.service.national.ChangeApplyService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

/**
 * @outhor lujian
 * @create 2018-07-02 16:55
 */
@Service
public class ChangeApplyServiceImpl extends ApiService<ChangeApplyParam, ApiResult<ChangeApplyResultVO>> implements ChangeApplyService {
    @Override
    protected String getTag() {
        return "flight.national.supply.sl.applyChange";
    }

    @Override
    protected TypeReference<ApiResult<ChangeApplyResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<ChangeApplyResultVO>>() {
        };
    }

    @Override
    public ApiResult<ChangeApplyResultVO> changeApply(final ChangeApplyParam changeApplyParam) {
        ApiResult<ChangeApplyResultVO> apiResult = execute(changeApplyParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), ChangeApplyResultVO.class));
    }
}
