package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.BookingResultVO;
import com.apin.qunar.order.domain.national.createOrder.CreateOrderParam;
import com.apin.qunar.order.domain.national.createOrder.CreateOrderRequestBO;
import com.apin.qunar.order.domain.national.createOrder.CreateOrderResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:07
 */
public interface CreateOrderService {
    ApiResult<CreateOrderResultVO> createOrder(final CreateOrderRequestBO createOrderRequestBO, final CreateOrderParam createOrderParam, final BookingResultVO bookingResult);
}
