package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.cancelOrder.NtsCancelOrderParam;
import com.apin.qunar.order.domain.international.cancelOrder.NtsCancelOrderResultVO;
import com.apin.qunar.order.service.international.NtsCancelOrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

/**
 * @outhor lujian
 * @create 2018-06-25 14:51
 */
@Service
public class NtsCancelOrderServiceImpl extends NtsApiService<NtsCancelOrderParam, ApiResult<NtsCancelOrderResultVO>> implements NtsCancelOrderService {
    @Override
    protected String getTag() {
        return "flight.international.supply.sl.cancelOrder";
    }

    @Override
    protected TypeReference<ApiResult<NtsCancelOrderResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsCancelOrderResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsCancelOrderResultVO> cancelOrder(final NtsCancelOrderParam ntsCancelOrderParam) {
        ApiResult<NtsCancelOrderResultVO> apiResult = execute(ntsCancelOrderParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        return  apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), NtsCancelOrderResultVO.class));
    }
}
