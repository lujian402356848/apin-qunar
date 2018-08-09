package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsPayRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.pay.NtsPayParam;
import com.apin.qunar.order.domain.international.pay.NtsPayResultVO;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateParam;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateResultVO;
import com.apin.qunar.order.service.international.NtsPayService;
import com.apin.qunar.order.service.international.NtsPayValidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 支付
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsPayController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NtsPayService ntsPayService;
    @Autowired
    private NtsPayValidateService ntsPayValidateService;

    @PostMapping(value = "/ntsOrder/pay")
    public GeneralResultMap pay(@RequestBody NtsPayRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsOrder/pay接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<NtsPayValidateResultVO> payValidateResult = ntsPayValidateService.payValidate(buildNtsPayValidateParam(request.getOrderNo()));
            if (payValidateResult.isSuccess()) {
                ApiResult<NtsPayResultVO> payResult = ntsPayService.pay(buildNtsPayParam(request));
                if (payResult.isSuccess()) {
                    generalResultMap.setResult(SysReturnCode.SUCC, payResult.getResult());
                } else {
                    generalResultMap.setResult(payResult.getCode(), payResult.getMessage());
                }
            } else {
                generalResultMap.setResult(payValidateResult.getCode(), payValidateResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际机票支付失败,request:{}", request, e);
        }
        return generalResultMap;
    }

    private NtsPayParam buildNtsPayParam(final NtsPayRequest ntsPayRequest) {
        NtsPayParam ntsPayParam = new NtsPayParam();
        ntsPayParam.setOrderNo(ntsPayRequest.getOrderNo());
        ntsPayParam.setSource(orderConfig.getInternationalSource());
        ntsPayParam.setPmcode(orderConfig.getPayType());
        ntsPayParam.setBankcode(orderConfig.getBankCode());
        ntsPayParam.setPaymentMerchantCode(orderConfig.getPayAccount());
        return ntsPayParam;
    }

    private NtsPayValidateParam buildNtsPayValidateParam(final String orderNo) {
        NtsPayValidateParam ntsPayValidateParam = new NtsPayValidateParam();
        ntsPayValidateParam.setOrderNo(orderNo);
        ntsPayValidateParam.setSource(orderConfig.getInternationalSource());
        return ntsPayValidateParam;
    }
}
