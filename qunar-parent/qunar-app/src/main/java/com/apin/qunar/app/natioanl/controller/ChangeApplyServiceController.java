package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.change.ChangeApplyRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyParam;
import com.apin.qunar.order.domain.national.changeApply.ChangeApplyResultVO;
import com.apin.qunar.order.service.national.ChangeApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-07-02 16:58
 * 改签
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class ChangeApplyServiceController extends BaseController {
    @Autowired
    private ChangeApplyService changeService;

    @PostMapping(value = "/order/changeApply")
    public GeneralResultMap changeApply(@RequestBody ChangeApplyRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/changeApply接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<ChangeApplyResultVO> apiResult = changeService.changeApply(buildChangeParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, apiResult.getMessage());
            }
        } catch (Exception e) {
            log.info("国内改签订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private ChangeApplyParam buildChangeParam(final ChangeApplyRequest changeApplyRequest) {
        ChangeApplyParam changeApplyParam = new ChangeApplyParam();
        return changeApplyParam;
    }
}
