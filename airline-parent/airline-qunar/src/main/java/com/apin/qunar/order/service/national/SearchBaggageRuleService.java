package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchBaggageRule.SearchBaggageRuleParam;
import com.apin.qunar.order.domain.national.searchBaggageRule.SearchBaggageRuleResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:06
 */
public interface SearchBaggageRuleService {
    ApiResult<SearchBaggageRuleResultVO> searchBaggageRule(final SearchBaggageRuleParam searchBaggageRuleParam);
}
