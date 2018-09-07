package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceParam;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:33
 */
public interface NtsSearchPriceService {
    ApiResult<NtsSearchPriceResultVO> searchPrice(final NtsSearchPriceParam ntsPriceSearchParam, final String merchantNo);
}
