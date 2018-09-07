package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchPrice.SearchPriceParam;
import com.apin.qunar.order.domain.national.searchPrice.SearchPriceResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:09
 */
public interface SearchPriceService {
    ApiResult<SearchPriceResultVO> searchPrice(final SearchPriceParam searchPriceParam, final String merchantNo);
}
