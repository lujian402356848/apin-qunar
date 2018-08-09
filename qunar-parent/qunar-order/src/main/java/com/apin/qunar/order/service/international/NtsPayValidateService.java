package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateParam;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:32
 */
public interface NtsPayValidateService {
    ApiResult<NtsPayValidateResultVO> payValidate(final NtsPayValidateParam ntsPayValidateParam);
}
