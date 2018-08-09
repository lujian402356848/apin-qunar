package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.change.ChangeSearchRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.changeSearch.ChangeSearchParam;
import com.apin.qunar.order.domain.national.changeSearch.ChangeSearchResultVO;
import com.apin.qunar.order.service.national.ChangeSearchService;
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
 * @outhor lujian
 * @create 2018-07-02 16:49
 * 改签查询
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class ChangeSearchController extends BaseController {
    @Autowired
    private ChangeSearchService changeSearchService;

    @PostMapping(value = "/order/changeSearch")
    public GeneralResultMap changeSearch(@RequestBody ChangeSearchRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/changeSearch接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        try {
            ApiResult<List<ChangeSearchResultVO>> apiResult = changeSearchService.changeSearch(buildChangeSearchParam(request));
            if (apiResult.isSuccess()) {
                data.put("passengerList", apiResult.getResult());
                generalResultMap.setResult(SysReturnCode.SUCC, data);
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL, apiResult.getMessage());
            }
        } catch (Exception e) {
            log.info("国内查询改签订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private ChangeSearchParam buildChangeSearchParam(final ChangeSearchRequest changeSearchRequest) {
        ChangeSearchParam changeSearchParam = new ChangeSearchParam();
        changeSearchParam.setOrderNo(changeSearchRequest.getOrderNo());
        changeSearchParam.setChangeDate(changeSearchRequest.getChangeDate());
        return changeSearchParam;
    }
}
