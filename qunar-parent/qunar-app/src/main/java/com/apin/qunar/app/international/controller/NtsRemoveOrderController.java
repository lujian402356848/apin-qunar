package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsRemoveOrderRequest;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.service.international.NtsRemoveOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsRemoveOrderController extends BaseController {
    @Resource
    private NtsRemoveOrderService ntsRemoveOrderService;

    @PostMapping(value = "/ntsOrder/remove")
    public GeneralResultMap remove(@RequestBody @Valid NtsRemoveOrderRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsOrder/remove接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ExecuteResult executeResult = ntsRemoveOrderService.remove(request.getOrderNo(), request.getAccount());
            if (executeResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, executeResult.getDesc());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("删除国际订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }

}
