package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsSearchPriceRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceParam;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceResultVO;
import com.apin.qunar.order.service.international.NtsSearchPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 查询报价
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsSearchPriceController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NtsSearchPriceService ntsSearchPriceService;

    @PostMapping(value = "/ntsSearch/price")
    public GeneralResultMap searchPrice(@RequestBody NtsSearchPriceRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsSearch/price接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<NtsSearchPriceResultVO> apiResult = ntsSearchPriceService.searchPrice(buildNtsSearchPriceParam(request), request.getMerchantNo());
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, "航班信息发生变动，请重新搜索");
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际查询航班价格异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private NtsSearchPriceParam buildNtsSearchPriceParam(final NtsSearchPriceRequest ntsSearchPriceRequest) {
        NtsSearchPriceParam ntsSearchPriceParam = new NtsSearchPriceParam();
        ntsSearchPriceParam.setDepCity(ntsSearchPriceRequest.getDepCity());
        ntsSearchPriceParam.setArrCity(ntsSearchPriceRequest.getArrCity());
        ntsSearchPriceParam.setDepDate(ntsSearchPriceRequest.getDepDate());
        ntsSearchPriceParam.setRetDate(ntsSearchPriceRequest.getRetDate());
        ntsSearchPriceParam.setSource(orderConfig.getInternationalSource());
        ntsSearchPriceParam.setFlightCode(ntsSearchPriceRequest.getFlightCode());
        ntsSearchPriceParam.setAdultNum(ntsSearchPriceRequest.getAdultNum());
        ntsSearchPriceParam.setChildNum(ntsSearchPriceRequest.getChildNum());
        ntsSearchPriceParam.setCabinLevel(ntsSearchPriceRequest.getCabinLevel());
        return ntsSearchPriceParam;
    }
}