package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.enums.NtsOrderStatusEnum;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.pay.NtsPayParam;
import com.apin.qunar.order.domain.international.pay.NtsPayResultVO;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateParam;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateResultVO;
import com.apin.qunar.order.service.international.NtsPayService;
import com.apin.qunar.order.service.international.NtsPayValidateService;
import com.apin.qunar.order.service.international.NtsUpdateOrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class NtsPayServiceImpl extends NtsApiService<NtsPayParam, ApiResult<NtsPayResultVO>> implements NtsPayService {

    @Autowired
    private NtsUpdateOrderService ntsDbOrderService;
    @Autowired
    private NtsPayValidateService ntsPayValidateService;
    @Autowired
    private OrderConfig orderConfig;

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.pay";
    }

    @Override
    protected TypeReference<ApiResult<NtsPayResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsPayResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsPayResultVO> pay(final NtsPayParam ntsPayParam) {
        ExecuteResult executeResult = validatePay(ntsPayParam);
        if (!executeResult.isSuccess()) {
            return ApiResult.fail(SysReturnCode.FAIL.getCode(), executeResult.getDesc());
        }
        ApiResult<NtsPayResultVO> apiResult = execute(ntsPayParam);
        if (apiResult == null) {
            ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("国际订单支付失败,params:{},原因:{}", JSON.toJSONString(ntsPayParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        if (apiResult.getResult() != null) {
            ntsDbOrderService.updatePayInfo(ntsPayParam.getOrderNo(), StringUtils.join(apiResult.getResult().getPayIds(), ","), NtsOrderStatusEnum.PAY_OK.getCode(), formatToDate(apiResult.getCreateTime()));
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), NtsPayResultVO.class));
    }

    @Override
    public ExecuteResult validatePay(NtsPayParam ntsPayParam) {
        ExecuteResult executeResult = new ExecuteResult();
        NtsPayValidateParam ntsPayValidateParam = buildNtsPayValidateParam(ntsPayParam);
        ApiResult<NtsPayValidateResultVO> apiResult = ntsPayValidateService.payValidate(ntsPayValidateParam);
        if (apiResult == null) {
            executeResult.setDesc("支付验证失败，请从新下单");
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

    private NtsPayValidateParam buildNtsPayValidateParam(final NtsPayParam ntsPayParam) {
        NtsPayValidateParam ntsPayValidateParam = new NtsPayValidateParam();
        ntsPayValidateParam.setOrderNo(ntsPayParam.getOrderNo());
        ntsPayValidateParam.setSource(orderConfig.getInternationalSource());
        return ntsPayValidateParam;
    }

    private String formatToDate(long timeStamp) {
        return DateUtil.DEFAULT_FORMAT.format(new Date(timeStamp));
    }
}
