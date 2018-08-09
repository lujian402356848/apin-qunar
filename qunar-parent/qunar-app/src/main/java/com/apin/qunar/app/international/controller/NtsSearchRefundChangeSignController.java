package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsSearchRefundChangeSignRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignParam;
import com.apin.qunar.order.domain.international.searchRefundChangeSign.NtsSearchRefundChangeSignResultVO;
import com.apin.qunar.order.service.international.NtsSearchRefundChangeSignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-07-04 15:36
 * 查询退改签
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsSearchRefundChangeSignController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NtsSearchRefundChangeSignService ntsSearchRefundChangeSignService;

    @PostMapping(value = "/ntsSearch/refundChangeSign")
    public GeneralResultMap searchRefundChangeSign(@RequestBody NtsSearchRefundChangeSignRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsSearch/refundChangeSign接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<NtsSearchRefundChangeSignResultVO> apiResult = ntsSearchRefundChangeSignService.searchRefundChangeSign(buildNtsSearchRefundChangeSignParam(request));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际查询退改签异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private NtsSearchRefundChangeSignParam buildNtsSearchRefundChangeSignParam(final NtsSearchRefundChangeSignRequest ntsSearchRefundChangeSignRequest) {
        NtsSearchRefundChangeSignParam ntsSearchRefundChangeSignParam = new NtsSearchRefundChangeSignParam();
        ntsSearchRefundChangeSignParam.setSource(orderConfig.getInternationalSource());
        ntsSearchRefundChangeSignParam.setPricekey(ntsSearchRefundChangeSignRequest.getPricekey());
        ntsSearchRefundChangeSignParam.setPlaneType(ntsSearchRefundChangeSignRequest.getPlaneType());
        ntsSearchRefundChangeSignParam.setPassengerType(ntsSearchRefundChangeSignRequest.getPassengerType());
        return ntsSearchRefundChangeSignParam;
    }
}
