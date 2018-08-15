package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.enums.SysReturnCode;
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
        ExecuteResult executeResult = validatePay(payParam);
        if (!executeResult.isSuccess()) {
            return ApiResult.fail(SysReturnCode.FAIL.getCode(), executeResult.getDesc());
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
    public ExecuteResult validatePay(PayParam payParam) {
        ExecuteResult executeResult = new ExecuteResult();
        PayValidateParam payValidateParam = buildPayValidateParam(payParam);
        ApiResult<String> apiResult = payValidateService.validate(payValidateParam);
        if (apiResult == null) {
            executeResult.setDesc("支付验证失败，请重新下单");
            return executeResult;
        }
        boolean result = apiResult.isSuccess() && apiResult.getCode() == 0;
        executeResult.setSuccess(result);
        if (!result) {
            String msg = String.format("支付验证失败,原因:%s", apiResult.getMessage());
            executeResult.setDesc(msg);
            log.warn(msg);
        }
        return executeResult;
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
