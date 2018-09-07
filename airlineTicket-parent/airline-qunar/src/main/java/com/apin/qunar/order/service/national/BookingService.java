package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.BookingParam;
import com.apin.qunar.order.domain.national.booking.BookingResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:07
 */
public interface BookingService {
    ApiResult<BookingResultVO> booking(final BookingParam bookingParam);
}
