package com.apin.qunar.app.basic.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.AreaRequest;
import com.apin.qunar.app.basic.request.CityRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.domain.area.AreaVO;
import com.apin.qunar.basic.domain.city.CityVO;
import com.apin.qunar.basic.domain.provinces.ProvincesVO;
import com.apin.qunar.basic.service.CityService;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class CityController extends BaseController {

    @Autowired
    private CityService cityService;

    @PostMapping(value = "/search/province")
    public GeneralResultMap searchProvince() {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        try {
            List<ProvincesVO> provinces = cityService.queryProvince();
            generalResultMap.setResult(SysReturnCode.SUCC, provinces);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("获取省级信息异常", e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/search/city")
    public GeneralResultMap searchCity(@RequestBody CityRequest cityRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(cityRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/city接口基础验证不通过，request:{}", JSON.toJSON(cityRequest));
            return generalResultMap;
        }
        try {
            List<CityVO> cityVOS = cityService.queryByProvinceId(cityRequest.getProvinceId());
            generalResultMap.setResult(SysReturnCode.SUCC, cityVOS);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("获取市级信息异常,provinceId:{}", cityRequest.getProvinceId(), e);
        }
        return generalResultMap;
    }

    @PostMapping(value = "/search/area")
    public GeneralResultMap searchArea(@RequestBody AreaRequest areaRequest) {
        GeneralResultMap generalResultMap = validateCommonParam(areaRequest);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/area接口基础验证不通过，request:{}", JSON.toJSON(areaRequest));
            return generalResultMap;
        }
        try {
            List<AreaVO> areaVOS = cityService.queryByCityId(areaRequest.getCityId());
            generalResultMap.setResult(SysReturnCode.SUCC, areaVOS);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("获取区级信息异常,cityId:{}", areaRequest.getCityId(), e);
        }
        return generalResultMap;
    }

}
