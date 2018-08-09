package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyParam;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 16:56
 */
public interface ChangeApplyService {
    ApiResult<ChangeApplyResultVO> changeApply(final ChangeApplyParam changeApplyParam);
}
