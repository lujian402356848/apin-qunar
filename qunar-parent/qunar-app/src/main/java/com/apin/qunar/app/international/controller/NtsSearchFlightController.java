package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsSearchFlightRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightParam;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightResultVO;
import com.apin.qunar.order.service.international.NtsSearchFlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 查询航班
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsSearchFlightController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Resource
    private NtsSearchFlightService ntsSearchFlightService;

    @PostMapping(value = "/ntsSearch/flight")
    public GeneralResultMap searchFlight(@RequestBody @Valid NtsSearchFlightRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsSearch/flight接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        try {
            ApiResult<List<NtsSearchFlightResultVO>> apiResult = ntsSearchFlightService.searchFlight(buildNtsSearchFlightParam(request), request.getMerchantNo(), request.getAccount());
            if (apiResult.isSuccess()) {
                data.put("ntsFlightSearchResult", apiResult.getResult());
                data.put("depCity", request.getDepCity());
                data.put("arrCity", request.getArrCity());
                data.put("depDate", request.getDepDate());
                data.put("retDate", request.getRetDate());
                data.put("source", orderConfig.getInternationalSource());
                if (request.getAdultNum() != null) {
                    data.put("adultNum", request.getAdultNum());
                }
                if (request.getChildNum() != null) {
                    data.put("childNum", request.getChildNum());
                }
                if (request.getCabinLevel() != null) {
                    data.put("cabinLevel", request.getCabinLevel());
                }
                generalResultMap.setResult(SysReturnCode.SUCC, data);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际查询航班异常,request:{}", request, e);
        }


        return generalResultMap;
    }

    private NtsSearchFlightParam buildNtsSearchFlightParam(final NtsSearchFlightRequest ntsSearchFlightRequest) {
        NtsSearchFlightParam ntsSearchFlightParam = new NtsSearchFlightParam();
        ntsSearchFlightParam.setDepCity(ntsSearchFlightRequest.getDepCity());
        ntsSearchFlightParam.setArrCity(ntsSearchFlightRequest.getArrCity());
        ntsSearchFlightParam.setDepDate(ntsSearchFlightRequest.getDepDate());
        ntsSearchFlightParam.setRetDate(ntsSearchFlightRequest.getRetDate());
        ntsSearchFlightParam.setAdultNum(ntsSearchFlightRequest.getAdultNum());
        ntsSearchFlightParam.setChildNum(ntsSearchFlightRequest.getChildNum());
        ntsSearchFlightParam.setCabinLevel(ntsSearchFlightRequest.getCabinLevel());
        ntsSearchFlightParam.setSource(orderConfig.getInternationalSource());
        return ntsSearchFlightParam;
    }
}