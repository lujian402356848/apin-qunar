package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchChangeOrderDetail.SearchChangeOrderDetailResultVO;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;

/**
 * @outhor lujian
 * @create 2018-07-02 11:09
 */
public interface SearchChangeOrderDetailService {
    ApiResult<SearchChangeOrderDetailResultVO> searchOrderDetail(final SearchOrderDetailParam searchOrderDetailParam);
}
