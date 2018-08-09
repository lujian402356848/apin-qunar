package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.AirportRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.domain.airport.AirportVO;
import com.apin.qunar.basic.service.AirportService;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 10:56
 * 查询机场
 */
@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class AirportController extends BaseController {
    @Autowired
    AirportService airportService;

    @PostMapping(value = "/search/airport")
    public GeneralResultMap seachAirport(@RequestBody AirportRequest airportRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(airportRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/airport接口基础验证不通过，request:{}", JSON.toJSON(airportRequest));
            return generalResultMap;
        }
        try {
            List<AirportVO> airports = airportService.getByCode(airportRequest.getCode().toLowerCase());
            generalResultMap.setResult(SysReturnCode.SUCC, airports);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询机场信息异常,name:{}", airportRequest.getCode(), e);
        }
        return generalResultMap;
    }
}