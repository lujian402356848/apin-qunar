package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchReimburseVoucherListRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.dao.model.NationalReimburseVoucher;
import com.apin.qunar.order.service.national.SearchReimburseVoucherListService;
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
 * @create 2018-08-20 13:39
 * 查询报销凭证列表
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchReimburseVoucherListController extends BaseController {
    @Autowired
    private SearchReimburseVoucherListService searchReimburseVoucherListService;

    @PostMapping(value = "/search/reimburseVoucher")
    public GeneralResultMap searchReimburseVoucher(@RequestBody SearchReimburseVoucherListRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/reimburseVoucher接口基础验证不通过，request:{}", JSON.toJSON(request));
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
            List<NationalReimburseVoucher> nationalReimburseVoucherList = searchReimburseVoucherListService.queryPageList(request.getMerchantNo(), request.getOrderNo(), request.getOffset(), request.getLimit());
            Integer count = searchReimburseVoucherListService.queryPage(request.getMerchantNo(), request.getOrderNo());
            data.put("nationalReimburseVoucherList", nationalReimburseVoucherList);
            data.put("count", count);
            generalResultMap.setResult(SysReturnCode.SUCC, data);
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询报销凭证列表异常,request:{}", request, e);
        }
        return generalResultMap;
    }
}
