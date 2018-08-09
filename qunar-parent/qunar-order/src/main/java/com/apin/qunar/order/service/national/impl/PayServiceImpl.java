package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.pay.PayParam;
import com.apin.qunar.order.domain.national.pay.PayResultVO;
import com.apin.qunar.order.domain.national.payValidate.PayValidateParam;
import com.apin.qunar.order.service.national.PayService;
import com.apin.qunar.order.service.national.PayValidateService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class PayServiceImpl extends ApiService<PayParam, ApiResult<PayResultVO>> implements PayService {
    @Autowired
    private UpdateOrderServiceImpl dbOrderService;
    @Autowired
    private PayValidateService payValidateService;

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.pay";
    }

    @Override
    protected TypeReference<ApiResult<PayResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<PayResultVO>>() {
        };
    }

    @Override
    public ApiResult<PayResultVO> pay(final PayParam payParam) {
        boolean validateResult = validatePay(payParam);
        if (!validateResult) {
            return ApiResult.fail();
        }
        ApiResult<PayResultVO> apiResult = execute(payParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (apiResult.isSuccess() && apiResult.getResult() != null && CollectionUtils.isNotEmpty(apiResult.getResult().getResults())) {
            PayResultVO.PayFormResult payResult = apiResult.getResult().getResults().get(0);
            int payStatus = "SUCCESS".equalsIgnoreCase(payResult.getPayStatus()) ? 1 : 0;
            dbOrderService.updatePayInfo(payResult.getOrderNo(), payResult.getPayId(), payStatus, payResult.getPayTime());
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), PayResultVO.class));
    }

    @Override
    public boolean validatePay(PayParam payParam) {
        PayValidateParam payValidateParam = buildPayValidateParam(payParam);
        ApiResult<String> apiResult = payValidateService.validate(payValidateParam);
        if (apiResult == null) {
            return false;
        }
        boolean result = apiResult.isSuccess() && apiResult.getCode() == 0;
        if (!result) {
            log.warn("国内支付校验失败,result:{}", JSON.toJSON(apiResult));
        }
        return result;
    }

    private PayValidateParam buildPayValidateParam(PayParam payParam) {
        PayValidateParam payValidateParam = new PayValidateParam();
        payValidateParam.setOrderId(payParam.getOrderId());
        payValidateParam.setBankCode(payParam.getBankCode());
        payValidateParam.setPmCode(payParam.getPmCode());
        payValidateParam.setClientSite(payParam.getClientSite());
        return payValidateParam;
    }
}
