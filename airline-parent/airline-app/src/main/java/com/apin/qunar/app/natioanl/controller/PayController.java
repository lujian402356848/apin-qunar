package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.PayRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.pay.PayParam;
import com.apin.qunar.order.domain.national.pay.PayResultVO;
import com.apin.qunar.order.service.national.PayService;
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
 * 订单支付
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class PayController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private PayService payService;

    @PostMapping(value = "/order/pay")
    public GeneralResultMap pay(@RequestBody@Valid PayRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/pay接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<PayResultVO> apiResult = payService.pay(buildPayParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内机票支付失败,request:{}", request, e);
        }
        return generalResultMap;
    }

    private PayParam buildPayParam(final PayRequest payRequest) {
        PayParam payParam = new PayParam();
        payParam.setClientSite(payRequest.getClientSite());
        payParam.setOrderId(payRequest.getOrderId());
        payParam.setPmCode(orderConfig.getPayType());
        payParam.setBankCode(orderConfig.getBankCode());
        payParam.setPaymentMerchantCode(orderConfig.getPayAccount());
        payParam.setCurId("CNY");
        payParam.setBgRetUrl(orderConfig.getPayCallbackUrl());
        return payParam;
    }
}