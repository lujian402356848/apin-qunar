package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changePay.ChangePayParam;
import com.apin.qunar.order.domain.national.changePay.ChangePayResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 18:49
 */
public interface ChangePayService {
    ApiResult<ChangePayResultVO> changePay(final ChangePayParam changePayParam);
}
