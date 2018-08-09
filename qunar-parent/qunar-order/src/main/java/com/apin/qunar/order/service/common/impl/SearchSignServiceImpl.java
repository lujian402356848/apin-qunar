package com.apin.qunar.order.service.common.impl;

import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.common.searchSign.SearchSignParam;
import com.apin.qunar.order.domain.common.searchSign.SearchSignResultVO;
import com.apin.qunar.order.service.common.SearchSignService;
import com.apin.qunar.order.service.national.impl.ApiService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

/**
 * @outhor lujian
 * @create 2018-06-23 18:04
 */
@Service
public class SearchSignServiceImpl extends ApiService<SearchSignParam, ApiResult<SearchSignResultVO>> implements SearchSignService {

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.SignQuery";
    }

    @Override
    protected TypeReference<ApiResult<SearchSignResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SearchSignResultVO>>() {
        };
    }

    @Override
    public ApiResult<SearchSignResultVO> searchSign(SearchSignParam searchSignParam) {
        ApiResult<SearchSignResultVO> apiResult = execute(searchSignParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), SearchSignResultVO.class));
    }
}
