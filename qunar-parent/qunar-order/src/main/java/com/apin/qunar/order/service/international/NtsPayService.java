package com.apin.qunar.order.service.international;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.pay.NtsPayParam;
import com.apin.qunar.order.domain.international.pay.NtsPayResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:32
 */
public interface NtsPayService {
    ExecuteResult validatePay(NtsPayParam ntsPayParam);

    ApiResult<NtsPayResultVO> pay(final NtsPayParam ntsPayParam);
}
