package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsPayValidateRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateParam;
import com.apin.qunar.order.domain.international.payValidate.NtsPayValidateResultVO;
import com.apin.qunar.order.service.international.NtsPayValidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 支付验证
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsPayValidateController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NtsPayValidateService ntsPayValidateService;

    @PostMapping(value = "/ntsOrder/payValidate")
    public GeneralResultMap payValidate(@RequestBody NtsPayValidateRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsOrder/payValidate接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        try {
            ApiResult<NtsPayValidateResultVO> apiResult = ntsPayValidateService.payValidate(buildNtsPayValidateParam(request));
            if (apiResult.isSuccess()) {
                data.put("ntsPayValidateResult", apiResult.getResult());
                data.put("orderNo", request.getOrderNo());
                generalResultMap.setResult(SysReturnCode.SUCC, data);
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            log.error("国际校验支付异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private NtsPayValidateParam buildNtsPayValidateParam(final NtsPayValidateRequest payValidateRequest) {
        NtsPayValidateParam ntsPayValidateParam = new NtsPayValidateParam();
        ntsPayValidateParam.setOrderNo(payValidateRequest.getOrderNo());
        ntsPayValidateParam.setSource(orderConfig.getInternationalSource());
        return ntsPayValidateParam;
    }
}
