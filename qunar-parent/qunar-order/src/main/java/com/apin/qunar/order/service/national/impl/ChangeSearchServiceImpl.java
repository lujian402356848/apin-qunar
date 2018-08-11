package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeSearch.ChangeSearchParam;
import com.apin.qunar.order.domain.national.changeSearch.ChangeSearchResultVO;
import com.apin.qunar.order.service.national.ChangeSearchService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 11:01
 */
@Slf4j
@Service
public class ChangeSearchServiceImpl extends ApiService<ChangeSearchParam, ApiResult<List<ChangeSearchResultVO>>> implements ChangeSearchService {
    @Override
    protected String getTag() {
        return "flight.national.supply.sl.changeSearch";
    }

    @Override
    protected TypeReference<ApiResult<List<ChangeSearchResultVO>>> getTypeReference() {
        return new TypeReference<ApiResult<List<ChangeSearchResultVO>>>() {
        };
    }

    @Override
    public ApiResult<List<ChangeSearchResultVO>> changeSearch(final ChangeSearchParam changeSearchParam) {
        ApiResult<List<ChangeSearchResultVO>> apiResult = execute(changeSearchParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("国内订单改签查询失败,params:{},原因:{}", JSON.toJSON(changeSearchParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), ChangeSearchResultVO.class));
    }
}
