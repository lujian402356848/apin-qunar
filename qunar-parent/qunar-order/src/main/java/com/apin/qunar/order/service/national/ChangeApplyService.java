package com.apin.qunar.order.service.national;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyBO;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyResultVO;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 16:56
 */
public interface ChangeApplyService {
    ApiResult<List<ChangeApplyResultVO>> changeApply(final ChangeApplyBO changeApplyBO, final String account, final String MerchantNo);
}
