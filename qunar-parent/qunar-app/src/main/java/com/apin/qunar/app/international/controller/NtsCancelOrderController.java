package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsCancelOrderRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.cancelOrder.NtsCancelOrderParam;
import com.apin.qunar.order.domain.international.cancelOrder.NtsCancelOrderResultVO;
import com.apin.qunar.order.service.international.NtsCancelOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 取消订单
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsCancelOrderController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NtsCancelOrderService ntsCancelOrderService;


    @PostMapping(value = "/ntsOrder/cancel")
    public GeneralResultMap cancelOrder(@RequestBody NtsCancelOrderRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsOrder/cancel接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        if (StringUtils.isBlank(request.getOrderNo())) {
            log.error("参数错误,orderNo为空");
            return generalResultMap;
        }
        try {
            ApiResult<NtsCancelOrderResultVO> apiResult = ntsCancelOrderService.cancelOrder(buildNtsCancelOrderParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际取消订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private NtsCancelOrderParam buildNtsCancelOrderParam(NtsCancelOrderRequest ntsCancelOrderRequest) {
        NtsCancelOrderParam ntsCancelOrderParam = new NtsCancelOrderParam();
        ntsCancelOrderParam.setOrderNo(ntsCancelOrderRequest.getOrderNo());
        ntsCancelOrderParam.setSource(orderConfig.getInternationalSource());
        return ntsCancelOrderParam;
    }
}
