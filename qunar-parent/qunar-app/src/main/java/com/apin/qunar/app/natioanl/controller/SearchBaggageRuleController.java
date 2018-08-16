package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchBaggageRuleRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchBaggageRule.SearchBaggageRuleParam;
import com.apin.qunar.order.domain.national.searchBaggageRule.SearchBaggageRuleResultVO;
import com.apin.qunar.order.service.national.SearchBaggageRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @outhor lujian
 * @create 2018-06-27 16:34
 * 查询行李规则
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchBaggageRuleController extends BaseController {
    @Autowired
    SearchBaggageRuleService searchBaggageRuleService;

    @PostMapping(value = "/search/baggageRule")
    public GeneralResultMap searchBaggageRule(@RequestBody@Valid SearchBaggageRuleRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/baggageRule接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<SearchBaggageRuleResultVO> apiResult = searchBaggageRuleService.searchBaggageRule(buildSearchBaggageRuleParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询行李规则异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private SearchBaggageRuleParam buildSearchBaggageRuleParam(final SearchBaggageRuleRequest searchBaggageRequest) {
        SearchBaggageRuleParam searchBaggageRuleParam = new SearchBaggageRuleParam();
        searchBaggageRuleParam.setAirlineCode(searchBaggageRequest.getAirlineCode());
        searchBaggageRuleParam.setArrCode(searchBaggageRequest.getArrCode());
        searchBaggageRuleParam.setDepCode(searchBaggageRequest.getDepCode());
        searchBaggageRuleParam.setDepDate(searchBaggageRequest.getDepDate());
        searchBaggageRuleParam.setCabin(searchBaggageRequest.getCabin());
        searchBaggageRuleParam.setSaleDate(searchBaggageRequest.getSaleDate());
        return searchBaggageRuleParam;
    }
}
