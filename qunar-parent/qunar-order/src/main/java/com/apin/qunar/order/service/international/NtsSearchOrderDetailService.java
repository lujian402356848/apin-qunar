package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailBO;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailParam;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:33
 */
public interface NtsSearchOrderDetailService {
    ApiResult<NtsSearchOrderDetailResultVO> searchOrderDetail(final NtsSearchOrderDetailParam ntsSearchOrderDetailParam);
}