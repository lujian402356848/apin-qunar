package com.apin.qunar.app.group.controller;


import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.group.request.GroupOrderRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.group.searchOrderList.GroupOrderParam;
import com.apin.qunar.order.domain.group.searchOrderList.GroupOrderResultVO;
import com.apin.qunar.order.service.group.GroupOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class CreateGroupController extends BaseController {
    @Autowired
    private GroupOrderService groupOrderService;

    @PostMapping(value = "/group/order")
    public GeneralResultMap createGroup(@RequestBody GroupOrderRequest groupOrderRequest) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        Map<String, Object> data = new HashMap<>();
        try {
            List<GroupOrderResultVO> groupOrderResult = groupOrderService.queryList(buildGroupOrderParam(groupOrderRequest));
            data.put("orderList", groupOrderResult);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.info("拼团订单信息异常,request:{}", groupOrderRequest, e);
        }
        return generalResultMap;
    }

    private GroupOrderParam buildGroupOrderParam(final GroupOrderRequest groupOrderRequest) {
        GroupOrderParam groupOrderParam = new GroupOrderParam();
        groupOrderParam.setArriCity(groupOrderRequest.getArri_city());
        groupOrderParam.setDeptCity(groupOrderRequest.getDept_city());
        groupOrderParam.setDeptDate(groupOrderRequest.getDept_date());
        groupOrderParam.setPeopleCount(groupOrderRequest.getPeople_count());
        return groupOrderParam;
    }
}
