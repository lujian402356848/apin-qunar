package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:09
 */
public interface SearchOrderDetailService {
    ApiResult<SearchOrderDetailResultVO> searchOrderDetail(final SearchOrderDetailParam searchOrderDetailParam);
}
