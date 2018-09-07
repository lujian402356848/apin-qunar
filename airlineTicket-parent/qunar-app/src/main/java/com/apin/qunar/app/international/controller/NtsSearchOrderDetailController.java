package com.apin.qunar.app.international.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsSearchOrderDetailRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailParam;
import com.apin.qunar.order.domain.international.searchOrderDetail.NtsSearchOrderDetailResultVO;
import com.apin.qunar.order.service.international.NtsSearchOrderDetailService;
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
 * @create 2018-07-02 19:34
 * 查询订单明细
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsSearchOrderDetailController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    NtsSearchOrderDetailService ntsSearchOrderDetailService;

    @PostMapping(value = "/ntsOrder/detail")
    public GeneralResultMap searchOrderDetail(@RequestBody@Valid NtsSearchOrderDetailRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsOrder/detail接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<NtsSearchOrderDetailResultVO> apiResult = ntsSearchOrderDetailService.searchOrderDetail(buildNtsSearchOrderDetailParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际查询订单明细异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private NtsSearchOrderDetailParam buildNtsSearchOrderDetailParam(final NtsSearchOrderDetailRequest ntsSearchOrderDetailRequest) {
        NtsSearchOrderDetailParam ntsSearchOrderDetailParam = new NtsSearchOrderDetailParam();
        ntsSearchOrderDetailParam.setSource(orderConfig.getInternationalSource());
        ntsSearchOrderDetailParam.setOrderNo(ntsSearchOrderDetailRequest.getOrderNo());
        return ntsSearchOrderDetailParam;
    }
}