package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightParam;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightResultVO;

import java.util.List;

/**
 * @author lujian
 * @version 2018-07-23 16:49
 */
public interface NtsSearchFlightService {

    /**
     * 国际机票订单查询
     *
     * @param ntsSearchFlightParam 页面对象
     * @param account              账户信息
     * @return 页面返回数据
     */
    ApiResult<List<NtsSearchFlightResultVO>> searchFlight(NtsSearchFlightParam ntsSearchFlightParam, String merchantNo, String account);
}
