package com.apin.qunar.app.international.controller;


import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsChangeRegularPassengerRequest;
import com.apin.qunar.app.international.request.NtsCreateRegularPassengerRequest;
import com.apin.qunar.app.international.request.NtsRemoveRegularPassengerRequest;
import com.apin.qunar.app.international.request.NtsSearchRegularPassengerListRequest;
import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.international.regularPassenger.NtsRegularPassengerBO;
import com.apin.qunar.order.domain.international.regularPassenger.NtsRegularPassengerVO;
import com.apin.qunar.order.service.international.NtsRegularPassengerService;
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
public class NtsRegularPassengerController extends BaseController {
    @Autowired
    NtsRegularPassengerService ntsRregularPassengerService;

    @PostMapping(value = "/ntsPassenger/create")
    public GeneralResultMap create(@RequestBody NtsCreateRegularPassengerRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsPassenger/create接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ExecuteResult result = ntsRregularPassengerService.create(bulidNtsRegularPassenger(request));
            if (result.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, result.getDesc());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("新增常用乘客异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private NtsRegularPassengerBO bulidNtsRegularPassenger(NtsCreateRegularPassengerRequest request) {
        NtsRegularPassengerBO ntsRegularPassengerBO = new NtsRegularPassengerBO();
        ntsRegularPassengerBO.setBirthday(request.getBirthday());
        ntsRegularPassengerBO.setAgeType(request.getAgeType());
        ntsRegularPassengerBO.setCardNo(request.getCardNo());
        ntsRegularPassengerBO.setCardType(request.getCardType());
        ntsRegularPassengerBO.setGender("M".equals(request.getGender()) ? 0 : 1);
        ntsRegularPassengerBO.setMobileNo(request.getMobileNo());
        ntsRegularPassengerBO.setName(request.getName());
        ntsRegularPassengerBO.setCardExpired(request.getCardExpired());
        ntsRegularPassengerBO.setCardIssuePlace(request.getCardIssuePlace());
        ntsRegularPassengerBO.setNationality(request.getNationality());
        ntsRegularPassengerBO.setOperator(request.getAccount());
        return ntsRegularPassengerBO;
    }

    private NtsRegularPassengerBO bulidRegularPassenger(NtsChangeRegularPassengerRequest request) {
        NtsRegularPassengerBO ntsRegularPassengerBO = new NtsRegularPassengerBO();
        ntsRegularPassengerBO.setId(request.getId());
        ntsRegularPassengerBO.setBirthday(request.getBirthday());
        ntsRegularPassengerBO.setAgeType(request.getAgeType());
        ntsRegularPassengerBO.setCardNo(request.getCardNo());
        ntsRegularPassengerBO.setCardType(request.getCardType());
        ntsRegularPassengerBO.setGender("M".equals(request.getGender()) ? 0 : 1);
        ntsRegularPassengerBO.setMobileNo(request.getMobileNo());
        ntsRegularPassengerBO.setName(request.getName());
        ntsRegularPassengerBO.setCardExpired(request.getCardExpired());
        ntsRegularPassengerBO.setCardIssuePlace(request.getCardIssuePlace());
        ntsRegularPassengerBO.setNationality(request.getNationality());
        return ntsRegularPassengerBO;
    }

    @PostMapping(value = "/ntsPassenger/change")
    public GeneralResultMap change(@RequestBody NtsChangeRegularPassengerRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsPassenger/change接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            boolean result = ntsRregularPassengerService.change(bulidRegularPassenger(request));
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


    @PostMapping(value = "/ntsPassenger/remove")
    public GeneralResultMap delete(@RequestBody NtsRemoveRegularPassengerRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsPassenger/remove接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            boolean result = ntsRregularPassengerService.remove(request.getId());
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


    @PostMapping(value = "/ntsPassenger/list")
    public GeneralResultMap searchList(@RequestBody NtsSearchRegularPassengerListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        Map map = new HashMap();
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsPassenger/list接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        if (request.getOffset() == null || request.getOffset() <= 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        try {
            List<NtsRegularPassengerVO> ntsRegularPassengerVO = ntsRregularPassengerService.queryPageListBy(request.getAccount(), request.getName(), request.getOffset(), request.getLimit());
            Integer count = ntsRregularPassengerService.queryCount(request.getAccount(), request.getName());
            map.put("count", count);
            map.put("ntsPassengerList", ntsRegularPassengerVO);
            generalResultMap.setResult(SysReturnCode.SUCC, map);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询常用乘客信息列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

}
