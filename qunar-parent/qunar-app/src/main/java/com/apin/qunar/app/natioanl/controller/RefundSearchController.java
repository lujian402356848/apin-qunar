package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.RefundSearchRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchParam;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchResultVO;
import com.apin.qunar.order.service.national.RefundSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:29
 * 退款查询
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class RefundSearchController extends BaseController {
    @Autowired
    private RefundSearchService refundSearchService;

    @PostMapping(value = "/order/refundSearch")
    public GeneralResultMap refundSearch(@RequestBody RefundSearchRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/refundSearch接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<List<RefundSearchResultVO>> apiResult = refundSearchService.refundSearch(buildRefundSearchParam(request), request.getMerchantNo());
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内退票查询异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private RefundSearchParam buildRefundSearchParam(final RefundSearchRequest refundSearchRequest) {
        RefundSearchParam refundSearchParam = new RefundSearchParam();
        refundSearchParam.setOrderNo(refundSearchRequest.getOrderNo());
        return refundSearchParam;
    }
}
