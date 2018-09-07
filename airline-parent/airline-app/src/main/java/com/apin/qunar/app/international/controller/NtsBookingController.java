package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsBookingRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.booking.NtsBookingParam;
import com.apin.qunar.order.domain.international.booking.NtsBookingResultVO;
import com.apin.qunar.order.service.international.NtsBookingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 预定
 */

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class NtsBookingController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NtsBookingService ntsBookingService;


    @PostMapping(value = "/ntsOrder/booking")
    public GeneralResultMap booking(@Valid @RequestBody NtsBookingRequest ntsBookingRequest, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(ntsBookingRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsOrder/booking接口基础验证不通过，request:{}", JSON.toJSON(ntsBookingRequest));
            return generalResultMap;
        }

        try {
            ApiResult<NtsBookingResultVO> ntsBookingResult = ntsBookingService.booking(buildNtsBookingParam(ntsBookingRequest), ntsBookingRequest.getMerchantNo());
            if (ntsBookingResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, ntsBookingResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, "航班信息发生变更，请重新搜索");
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.info("国际预定订单异常,request:{}", ntsBookingRequest, e);
        }
        return generalResultMap;
    }

    private NtsBookingParam buildNtsBookingParam(final NtsBookingRequest ntsBookingRequest) {
        NtsBookingParam ntsBookingParam = new NtsBookingParam();
        ntsBookingParam.setPriceKey(ntsBookingRequest.getPriceKey());
        ntsBookingParam.setSource(orderConfig.getInternationalSource());
        return ntsBookingParam;
    }

}