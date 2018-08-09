package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
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
        boolean validateResult = validatePay(ntsPayParam);
        if (!validateResult) {
            return ApiResult.fail();
        }
        ApiResult<NtsPayResultVO> apiResult = execute(ntsPayParam);
        if (apiResult == null) {
            ApiResult.fail();
        }
        if (apiResult.isSuccess() && apiResult.getResult() != null) {
            ntsDbOrderService.updatePayInfo(ntsPayParam.getOrderNo(), StringUtils.join(apiResult.getResult().getPayIds(), ","), NtsOrderStatusEnum.PAY_OK.getCode(), fomatToDate(apiResult.getCreateTime()));
        }
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), NtsPayResultVO.class));
    }

    @Override
    public boolean validatePay(NtsPayParam ntsPayParam) {
        NtsPayValidateParam ntsPayValidateParam = buildNtsPayValidateParam(ntsPayParam);
        ApiResult<NtsPayValidateResultVO> apiResult = ntsPayValidateService.payValidate(ntsPayValidateParam);
        if (apiResult == null) {
            return false;
        }
        boolean result = apiResult.isSuccess() && apiResult.getCode() == 0;
        if (!result) {
            log.warn("国际支付校验失败,result:{}", JSON.toJSON(apiResult));
        }
        return result;
    }

    private NtsPayValidateParam buildNtsPayValidateParam(final NtsPayParam ntsPayParam) {
        NtsPayValidateParam ntsPayValidateParam = new NtsPayValidateParam();
        ntsPayValidateParam.setOrderNo(ntsPayParam.getOrderNo());
        ntsPayValidateParam.setSource(orderConfig.getInternationalSource());
        return ntsPayValidateParam;
    }

    private String fomatToDate(long timeStamp) {
        return DateUtil.DEFAULT_FORMAT.format(new Date(timeStamp));
    }
}
