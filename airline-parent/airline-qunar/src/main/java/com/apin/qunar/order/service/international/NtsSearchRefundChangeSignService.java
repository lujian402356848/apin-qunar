package com.apin.qunar.order.service.international;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignParam;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignResultVO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:09
 */
public interface NtsSearchRefundChangeSignService {
    ApiResult<NtsSearchRefundChangeSignResultVO> searchRefundChangeSign(final NtsSearchRefundChangeSignParam ntsSearchRefundChangeSignParam);
}