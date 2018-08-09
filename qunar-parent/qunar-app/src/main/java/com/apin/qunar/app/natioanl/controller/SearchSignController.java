package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchSignRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.common.searchSign.SearchSignParam;
import com.apin.qunar.order.domain.common.searchSign.SearchSignResultVO;
import com.apin.qunar.order.service.common.SearchSignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-06-27 17:24
 * 查询签约
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchSignController extends BaseController {
    @Autowired
    private SearchSignService searchSignService;

    @PostMapping(value = "/search/sign")
    public GeneralResultMap searchSign(@RequestBody SearchSignRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/sign接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<SearchSignResultVO> apiResult = searchSignService.searchSign(buildSearchSignParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询签约失败,request:{}", request, e);
        }
        return generalResultMap;
    }

    private SearchSignParam buildSearchSignParam(final SearchSignRequest searchSignRequest) {
        SearchSignParam searchPriceParam = new SearchSignParam();
        searchPriceParam.setBankCode(searchSignRequest.getBankCode());
        searchPriceParam.setSignedAccount(searchSignRequest.getSignedAccount());
        return searchPriceParam;
    }
}