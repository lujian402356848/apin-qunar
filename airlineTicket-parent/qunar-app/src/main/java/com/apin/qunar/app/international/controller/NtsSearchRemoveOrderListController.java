package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchRemoveOrderListRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.international.searchOrderList.InternationalOrderVO;
import com.apin.qunar.order.service.international.NtsSearchRemoveOrderListService;
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
 * @create 2018-06-27 16:34
 * 查询已删除订单列表
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsSearchRemoveOrderListController extends BaseController {
    @Autowired
    private NtsSearchRemoveOrderListService ntsSearchRemoveOrderListService;

    @PostMapping(value = "/ntsOrder/removeList")
    public GeneralResultMap searchRemoveOrderList(@RequestBody SearchRemoveOrderListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/ntsOrder/removeList接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        if (request.getOffset() == null || request.getOffset() <= 0) {
            request.setOffset(0);
        }
        if (request.getLimit() == null || request.getLimit() <= 0) {
            request.setLimit(20);
        }
        try {
            List<InternationalOrderVO> nationalOrderList = ntsSearchRemoveOrderListService.queryPageList(request.getAccount(), request.getStatus(), request.getOffset(), request.getLimit());
            Integer count = ntsSearchRemoveOrderListService.queryCount(request.getAccount(), request.getStatus());
            data.put("count", count);
            data.put("orderList", nationalOrderList);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际查询删除订单列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }

}
