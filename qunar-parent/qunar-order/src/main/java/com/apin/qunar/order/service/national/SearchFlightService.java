package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchFlight.SearchFlightParam;
import com.apin.qunar.order.domain.national.searchFlight.SearchFlightResultVO;

/**
 * @author lujian
 * @version 2018-07-23 16:49
 * 查询航班
 */
public interface SearchFlightService {

    /**
     * 调用携程的航班查询接口.
     *
     * @param searchFlightParam 携程需要的对象。
     * @param merchantNo        商户号，系统注册的时候会分配.
     * @return 页面需要对象信息
     */
    ApiResult<SearchFlightResultVO> searchFlight(final SearchFlightParam searchFlightParam, final String merchantNo);
}
