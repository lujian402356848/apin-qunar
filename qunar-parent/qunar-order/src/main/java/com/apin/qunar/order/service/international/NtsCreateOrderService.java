package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.booking.NtsBookingResultVO;
import com.apin.qunar.order.domain.international.createOrder.NtsCreateOrderParam;
import com.apin.qunar.order.domain.international.createOrder.NtsCreateOrderRequestBO;
import com.apin.qunar.order.domain.international.createOrder.NtsCreateOrderResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:31
 */
public interface NtsCreateOrderService {
    ApiResult<NtsCreateOrderResultVO> createOrder(final NtsCreateOrderRequestBO ntsCreateOrderRequest, final NtsCreateOrderParam ntsCreateOrderParam, final NtsBookingResultVO ntsBookingResult);
}