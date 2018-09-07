package com.apin.qunar.app.natioanl.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchOrderDetailRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailParam;
import com.apin.qunar.order.domain.national.searchOrderDetail.SearchOrderDetailResultVO;
import com.apin.qunar.order.service.national.SearchOrderDetailService;
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
 * 查询订单明细
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchOrderDetailController extends BaseController {
    @Autowired
    SearchOrderDetailService searchOrderDetailService;

    @PostMapping(value = "/order/detail")
    public GeneralResultMap searchOrderDetail(@RequestBody@Valid SearchOrderDetailRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/detail接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<SearchOrderDetailResultVO> apiResult = searchOrderDetailService.searchOrderDetail(buildSearchOrderDetailParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询订单明细异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private SearchOrderDetailParam buildSearchOrderDetailParam(final SearchOrderDetailRequest searchOrderDetailRequest) {
        SearchOrderDetailParam searchOrderDetailParam = new SearchOrderDetailParam();
        searchOrderDetailParam.setOrderNo(searchOrderDetailRequest.getOrderNo());
        return searchOrderDetailParam;
    }
}