package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchBaggageRule.SearchBaggageRuleParam;
import com.apin.qunar.order.domain.national.searchBaggageRule.SearchBaggageRuleResultVO;
import com.apin.qunar.order.service.national.SearchBaggageRuleService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

@Service
public class SearchBaggageRuleServiceImpl extends ApiService<SearchBaggageRuleParam, ApiResult<SearchBaggageRuleResultVO>> implements SearchBaggageRuleService {
    @Override
    protected String getTag() {
        return "flight.national.supply.sl.baggagerule";
    }

    @Override
    protected TypeReference<ApiResult<SearchBaggageRuleResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SearchBaggageRuleResultVO>>() {
        };
    }

    @Override
    public ApiResult<SearchBaggageRuleResultVO> searchBaggageRule(final SearchBaggageRuleParam searchBaggageRuleParam) {
        ApiResult<SearchBaggageRuleResultVO> apiResult = execute(searchBaggageRuleParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), SearchBaggageRuleResultVO.class));
    }
}
