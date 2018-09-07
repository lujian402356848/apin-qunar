package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.AirlineRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.domain.airline.AirlineVO;
import com.apin.qunar.basic.service.AirlineService;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor wubo
 * @create 2018-07-8 12:56
 * 查询航空公司
 */
@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class AirlineController extends BaseController {
    @Autowired
    AirlineService airlineService;

    @PostMapping(value = "/search/airline")
    public GeneralResultMap seachAirline(@RequestBody AirlineRequest airlineRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(airlineRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/airline接口基础验证不通过，request:{}", JSON.toJSON(airlineRequest));
            return generalResultMap;
        }
        try {
            AirlineVO airline = airlineService.getByLikeCode(airlineRequest.getCode());
            generalResultMap.setResult(SysReturnCode.SUCC, airline);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("航空公司信息异常,name:{}", airlineRequest.getCode(), e);
        }
        return generalResultMap;
    }
}
