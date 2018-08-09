package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.booking.NtsBookingParam;
import com.apin.qunar.order.domain.international.booking.NtsBookingResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:31
 */
public interface NtsBookingService {
    ApiResult<NtsBookingResultVO> booking(final NtsBookingParam ntsBookingParam, final String merchantNo);
}
