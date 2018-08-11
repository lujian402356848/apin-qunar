package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchFlightRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchFlight.SearchFlightParam;
import com.apin.qunar.order.domain.national.searchFlight.SearchFlightResultVO;
import com.apin.qunar.order.service.national.SearchFlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lujian
 * @version 2018-07-23 16:49
 * 查询航班
 */
@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchFlightController extends BaseController {

    @Resource
    private SearchFlightService searchFlightService;

    @PostMapping(value = "/search/flight")
    public GeneralResultMap searchFlight(@RequestBody SearchFlightRequest request) {

        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/flight接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }

        Map<String, Object> data = new HashMap<>();
        try {
            ApiResult<SearchFlightResultVO> apiResult = searchFlightService.searchFlight(buildSearchFlightParam(request), request.getMerchantNo());
            if (apiResult.isSuccess()) {

                SearchFlightResultVO searchFlightResult = apiResult.getResult();
                //航班具体信息
                data.put("flightInfos", searchFlightResult.getFlightInfos());
                data.put("date", request.getDate());
                //报价类型<目前只有优选>
                data.put("ex_track", request.getExTrack());
                generalResultMap.setResult(SysReturnCode.SUCC, data);
            } else {
                generalResultMap.setResult(apiResult.getCode(), "航班信息发生变动，请重新搜索");
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询航班异常,request:{}", request, e);
        }

        return generalResultMap;
    }

    private SearchFlightParam buildSearchFlightParam(final SearchFlightRequest searchFlightRequest) {
        SearchFlightParam searchFlightParam = new SearchFlightParam();
        searchFlightParam.setArr(searchFlightRequest.getArr());
        searchFlightParam.setDate(searchFlightRequest.getDate());
        searchFlightParam.setDpt(searchFlightRequest.getDpt());
        searchFlightParam.setEx_track(searchFlightRequest.getExTrack());
        searchFlightParam.setTakeoffTime(searchFlightRequest.getTakeoffTime());
        searchFlightParam.setTakeoffAirport(searchFlightRequest.getTakeoffAirport());
        searchFlightParam.setAirlineCompany(searchFlightRequest.getAirlineCompany());
        return searchFlightParam;
    }

}
