package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.payValidate.PayValidateParam;

/**
 * @outhor lujian
 * @create 2018-07-02 11:07
 */
public interface PayValidateService {
    ApiResult<String> validate(final PayValidateParam payValidateParam);
}
