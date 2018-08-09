package com.apin.qunar.app.natioanl.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.basic.request.RemoveRegularPassengerRequest;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.ChangeRegularPassengerRequest;
import com.apin.qunar.app.natioanl.request.CreateRegularPassengerRequest;
import com.apin.qunar.app.natioanl.request.SearchRegularPassengerListRequest;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.national.regularPassenger.RegularPassengerBO;
import com.apin.qunar.order.domain.national.regularPassenger.RegularPassengerVO;
import com.apin.qunar.order.service.national.RegularPassengerService;
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
 * @create 2018-08-07 09:51
 * 国内常旅客管理
 */

@Slf4j
@RestController
@RequestMapping(AppConstants.ROOT_URL)
public class RegularPassengerController extends BaseController {
    @Autowired
    RegularPassengerService regularPassengerService;

    @PostMapping(value = "/passenger/create")
    public GeneralResultMap create(@RequestBody CreateRegularPassengerRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/passenger/create接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ExecuteResult result = regularPassengerService.create(bulidRegularPassenger(request));
            if (result.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL,result.getDesc());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("新增常用乘客异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private RegularPassengerBO bulidRegularPassenger(CreateRegularPassengerRequest request) {
        RegularPassengerBO regularPassengerBO = new RegularPassengerBO();
        regularPassengerBO.setBirthday(request.getBirthday());
        regularPassengerBO.setAgeType(request.getAgeType());
        regularPassengerBO.setCardNo(request.getCardNo());
        regularPassengerBO.setCardType(request.getCardType());
        regularPassengerBO.setGender(request.getGender());
        regularPassengerBO.setMobileNo(request.getMobileNo());
        regularPassengerBO.setName(request.getName());
        regularPassengerBO.setOperator(request.getAccount());
        return regularPassengerBO;
    }

    private RegularPassengerBO bulidRegularPassenger(ChangeRegularPassengerRequest request) {
        RegularPassengerBO regularPassengerBO = new RegularPassengerBO();
        regularPassengerBO.setId(request.getId());
        regularPassengerBO.setBirthday(request.getBirthday());
        regularPassengerBO.setAgeType(request.getAgeType());
        regularPassengerBO.setCardNo(request.getCardNo());
        regularPassengerBO.setCardType(request.getCardType());
        regularPassengerBO.setGender(request.getGender());
        regularPassengerBO.setMobileNo(request.getMobileNo());
        regularPassengerBO.setName(request.getName());
        return regularPassengerBO;
    }

    @PostMapping(value = "/passenger/change")
    public GeneralResultMap change(@RequestBody ChangeRegularPassengerRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/passenger/change接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            boolean result = regularPassengerService.change(bulidRegularPassenger(request));
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("修改常用乘客信息异常,request:{}", request, e);
        }
        return generalResultMap;
    }


    @PostMapping(value = "/passenger/remove")
    public GeneralResultMap delete(@RequestBody RemoveRegularPassengerRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/passenger/remove接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            boolean result = regularPassengerService.delete(request.getId());
            if (result) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL);
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("删除常用乘客异常,request:{}", request, e);
        }
        return generalResultMap;
    }


    @PostMapping(value = "/passenger/list")
    public GeneralResultMap searchList(@RequestBody SearchRegularPassengerListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        Map map = new HashMap();
        if (!generalResultMap.isSuccess()) {
            log.warn("/passenger/list接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        if (request.getOffset() == null || request.getOffset() <= 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        try {
            List<RegularPassengerVO> regularPassengerVO = regularPassengerService.queryPageListBy(request.getAccount(), request.getName(), request.getOffset(), request.getLimit());
            map.put("passengerList", regularPassengerVO);
            generalResultMap.setResult(SysReturnCode.SUCC, map);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询常用乘客信息列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

}
