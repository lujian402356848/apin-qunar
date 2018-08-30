package com.apin.qunar.app.basic.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.CountryRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.service.CountryService;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @outhor ligang
 * @create 2018-08-30 19:01
 * 查询国籍信息
 */
@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class CountryController extends BaseController {
    @Autowired
    private CountryService countryService;

    @PostMapping(value = "/search/country")
    public GeneralResultMap seachAirport(@RequestBody CountryRequest countryRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(countryRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/country接口基础验证不通过，request:{}", JSON.toJSON(countryRequest));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        try {
            List<String> countrys = countryService.queryNameByKeyword(countryRequest.getCode());
            data.put("names",countrys);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询国籍信息异常,name:{}", countryRequest.getCode(), e);
        }
        return generalResultMap;
    }
}