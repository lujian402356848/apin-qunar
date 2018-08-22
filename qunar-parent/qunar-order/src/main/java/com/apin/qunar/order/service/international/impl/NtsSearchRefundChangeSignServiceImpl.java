package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignParam;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignResultVO;
import com.apin.qunar.order.service.international.NtsSearchRefundChangeSignService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

/**
 * @outhor lujian
 * @create 2018-07-04 15:40
 */
@Service
public class NtsSearchRefundChangeSignServiceImpl extends NtsApiService<NtsSearchRefundChangeSignParam, ApiResult<NtsSearchRefundChangeSignResultVO>> implements NtsSearchRefundChangeSignService {

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.tgqSearch";
    }

    @Override
    protected TypeReference<ApiResult<NtsSearchRefundChangeSignResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsSearchRefundChangeSignResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsSearchRefundChangeSignResultVO> searchRefundChangeSign(NtsSearchRefundChangeSignParam ntsSearchRefundChangeSignParam) {
        ApiResult<NtsSearchRefundChangeSignResultVO> apiResult = execute(ntsSearchRefundChangeSignParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        return apiResult;
    }
}