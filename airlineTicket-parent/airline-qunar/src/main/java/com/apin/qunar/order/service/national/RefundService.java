package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.refund.RefundRequestBO;
import com.apin.qunar.order.domain.national.refund.RefundResultVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 11:08
 */
public interface RefundService {
    ApiResult<List<RefundResultVO>> refund(final RefundRequestBO refundRequestBO);
}
