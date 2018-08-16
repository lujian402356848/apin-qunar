package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.change.ChangePayRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changePay.ChangePayParam;
import com.apin.qunar.order.domain.national.changePay.ChangePayResultVO;
import com.apin.qunar.order.service.national.ChangePayService;
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
 * 改签支付
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class ChangePayController extends BaseController {
    @Autowired
    private ChangePayService changePayService;
    @Autowired
    private OrderConfig orderConfig;

    @PostMapping(value = "/order/changePay")
    public GeneralResultMap changePay(@RequestBody@Valid ChangePayRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/changePay接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
                ApiResult<ChangePayResultVO> apiResult = changePayService.changePay(buildChangePayParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, apiResult.getMessage());
            }
        } catch (Exception e) {
            log.info("国内改签支付异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private ChangePayParam buildChangePayParam(final ChangePayRequest changePayRequest) {
        ChangePayParam changePayParam = new ChangePayParam();
        changePayParam.setOrderNo(changePayRequest.getOrderNo());
        changePayParam.setGqId(changePayRequest.getGqId());
        changePayParam.setPassengerIds(changePayRequest.getPassengerIds());
        changePayParam.setTotalAmount(changePayRequest.getTotalAmount());
        changePayParam.setPmCode(orderConfig.getPayType());
        changePayParam.setBankCode(orderConfig.getBankCode());
        changePayParam.setPaymentMerchantCode(orderConfig.getPayAccount());
        changePayParam.setCallbackUrl(orderConfig.getPayCallbackUrl());
        changePayParam.setCurId("CNY");
        changePayParam.setValidTime(changePayRequest.getValidTime());
        changePayParam.setApplyRemarks(changePayRequest.getApplyRemarks());
        return changePayParam;
    }
}
