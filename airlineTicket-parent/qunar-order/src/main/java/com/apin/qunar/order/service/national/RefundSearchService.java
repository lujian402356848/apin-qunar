package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchParam;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchResultVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 11:08
 */
public interface RefundSearchService {
    ApiResult<List<RefundSearchResultVO>> refundSearch(final RefundSearchParam refundSearchParam, final String merchantNo);
}
