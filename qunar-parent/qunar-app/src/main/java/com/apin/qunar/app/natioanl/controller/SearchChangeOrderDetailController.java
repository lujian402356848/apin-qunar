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
import com.apin.qunar.order.service.national.SearchChangeOrderDetailService;
import com.apin.qunar.order.service.national.SearchOrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor ligang
 * @create 2018-08-15 16:34
 * 查询改签订单明细
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchChangeOrderDetailController extends BaseController {
    @Autowired
    SearchChangeOrderDetailService searchChangeOrderDetailService;

    @PostMapping(value = "/changeOrder/detail")
    public GeneralResultMap searchOrderDetail(@RequestBody SearchOrderDetailRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/changeOrder/detail接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<SearchOrderDetailResultVO> apiResult = searchChangeOrderDetailService.searchOrderDetail(buildSearchOrderDetailParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询改签订单明细异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private SearchOrderDetailParam buildSearchOrderDetailParam(final SearchOrderDetailRequest searchOrderDetailRequest) {
        SearchOrderDetailParam searchOrderDetailParam = new SearchOrderDetailParam();
        searchOrderDetailParam.setOrderNo(searchOrderDetailRequest.getOrderNo());
        return searchOrderDetailParam;
    }
}