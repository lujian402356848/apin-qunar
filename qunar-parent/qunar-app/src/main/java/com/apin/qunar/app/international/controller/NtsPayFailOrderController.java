package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsSearchPayFailOrderRequest;
import com.apin.qunar.app.international.request.NtsUpdatePayFailOrderRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.utils.DateUtil;
import com.apin.qunar.order.domain.international.payFailOrder.NtsPayFailOrderVO;
import com.apin.qunar.order.service.international.NtsPayFailOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsPayFailOrderController extends BaseController {
    @Autowired
    private NtsPayFailOrderService ntsPayFailOrderService;

    @PostMapping(value = "/ntsPayFailOrder/list")
    public GeneralResultMap searchPayFailOrderList(@RequestBody NtsSearchPayFailOrderRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsPayFailOrder/list接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        if (request.getOffset() == null || request.getOffset() <= 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        try {
            Date startTime = DateUtil.getDateByYYYYMMDD(request.getStartTime());
            Date endTime = DateUtil.getDateByYYYYMMDD(request.getEndTime());
            List<NtsPayFailOrderVO> payFailOrders = ntsPayFailOrderService.queryPageList(request.getMerchantNo(), request.getOrderNo(), startTime, endTime, request.getOffset(), request.getLimit());
            data.put("orderList", payFailOrders);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际查询支付失败订单列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/ntsPayFailOrder/change")
    public GeneralResultMap change(@RequestBody NtsUpdatePayFailOrderRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsPayFailOrder/change接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            boolean result = ntsPayFailOrderService.updateOrder(request.getOrderNo(), request.getStatus(), request.getPayAmount(), request.getDesc(), request.getOperator());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC, result);
            } else {
                generalResultMap.setResult(SysReturnCode.SUCC, result);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际变更支付失败订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }
}
