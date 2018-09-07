package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchRefundChangeSign.SearchRefundChangeSignParam;
import com.apin.qunar.order.domain.national.searchRefundChangeSign.SearchRefundChangeSignResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:09
 */
public interface SearchRefundChangeSignService {
    ApiResult<SearchRefundChangeSignResultVO> searchRefundChangeSign(final SearchRefundChangeSignParam searchRefundChangeSignParam, final String merchantNo);
}