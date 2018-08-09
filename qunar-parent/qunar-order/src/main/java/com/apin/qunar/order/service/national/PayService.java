package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.pay.PayParam;
import com.apin.qunar.order.domain.national.pay.PayResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:07
 */
public interface PayService {
    boolean validatePay(PayParam payParam);

    ApiResult<PayResultVO> pay(final PayParam payRequest);
}
