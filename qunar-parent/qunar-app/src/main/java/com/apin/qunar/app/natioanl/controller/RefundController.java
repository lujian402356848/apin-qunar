package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.RefundRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.refund.RefundRequestBO;
import com.apin.qunar.order.domain.national.refund.RefundResultVO;
import com.apin.qunar.order.service.national.RefundSearchService;
import com.apin.qunar.order.service.national.RefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:29
 * 退款
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class RefundController extends BaseController {

    @Autowired
    private RefundSearchService refundSearchService;
    @Autowired
    private RefundService refundService;

    @PostMapping(value = "/order/refund")
    public GeneralResultMap refund(@RequestBody RefundRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/refund接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<List<RefundResultVO>> refundResult = refundService.refund(buildRefundRequestBO(request));
            if (refundResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, refundResult.getResult());
            } else {
                generalResultMap.setResult(refundResult.getCode());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内退票异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private RefundRequestBO buildRefundRequestBO(RefundRequest request) {
        RefundRequestBO refundRequestBO=new RefundRequestBO();
        refundRequestBO.setAccount(request.getAccount());
        refundRequestBO.setMerchantNo(request.getMerchantNo());
        refundRequestBO.setOrderNo(request.getOrderNo());
        refundRequestBO.setPassengerIds(request.getPassengerIds());
        refundRequestBO.setRefundCause(request.getRefundCause());
        refundRequestBO.setRefundCauseId(request.getRefundCauseId());
        return refundRequestBO;
    }


    @RequestMapping(value = "/refundCallback", method = {RequestMethod.POST})
    public void refundCallback() {

    }


}