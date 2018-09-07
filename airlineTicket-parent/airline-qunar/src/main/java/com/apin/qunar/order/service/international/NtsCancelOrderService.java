package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.cancelOrder.NtsCancelOrderParam;
import com.apin.qunar.order.domain.international.cancelOrder.NtsCancelOrderResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:31
 */
public interface NtsCancelOrderService {
    ApiResult<NtsCancelOrderResultVO> cancelOrder(final NtsCancelOrderParam ntsCancelOrderParam);
}
