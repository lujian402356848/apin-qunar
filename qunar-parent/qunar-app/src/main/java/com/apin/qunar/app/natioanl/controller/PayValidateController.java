package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.PayValidateRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.payValidate.PayValidateParam;
import com.apin.qunar.order.service.national.PayValidateService;
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
 * @create 2018-06-23 22:29
 * 订单支付验证
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class PayValidateController extends BaseController {
    @Autowired
    private PayValidateService payValidateService;

    @PostMapping(value = "/order/payValidate")
    public GeneralResultMap payValidate(@RequestBody@Valid PayValidateRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/payValidate接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<String> apiResult = payValidateService.validate(buildPayValidateParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, request);
            }
        } catch (Exception e) {
            log.error("国内校验支付异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private PayValidateParam buildPayValidateParam(PayValidateRequest payValidateRequest) {
        PayValidateParam payValidateParam = new PayValidateParam();
        payValidateParam.setOrderId(payValidateRequest.getOrderId());
        payValidateParam.setBankCode(payValidateParam.getBankCode());
        payValidateParam.setPmCode(payValidateParam.getPmCode());
        payValidateParam.setClientSite(payValidateParam.getClientSite());
        return payValidateParam;
    }
}
