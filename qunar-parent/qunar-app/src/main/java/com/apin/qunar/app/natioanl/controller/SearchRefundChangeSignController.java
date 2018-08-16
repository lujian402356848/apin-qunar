package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchRefundChangeSignRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchRefundChangeSign.SearchRefundChangeSignParam;
import com.apin.qunar.order.domain.national.searchRefundChangeSign.SearchRefundChangeSignResultVO;
import com.apin.qunar.order.service.national.SearchRefundChangeSignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @outhor lujian
 * @create 2018-06-27 17:24
 * 查询改签
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchRefundChangeSignController extends BaseController {
    @Autowired
    private SearchRefundChangeSignService searchRefundChangeSignService;

    @PostMapping(value = "/search/refundChangeSign")
    public GeneralResultMap searchRefundChangeSign(@RequestBody@Valid SearchRefundChangeSignRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/refundChangeSign接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<SearchRefundChangeSignResultVO> apiResult = searchRefundChangeSignService.searchRefundChangeSign(buildSearchTicketChangingParam(request), request.getMerchantNo());
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(), apiResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("查询退改签信息异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private SearchRefundChangeSignParam buildSearchTicketChangingParam(final SearchRefundChangeSignRequest searchRefundChangeSignRequest) {
        SearchRefundChangeSignParam searchRefundChangeSignParam = new SearchRefundChangeSignParam();
        searchRefundChangeSignParam.setFlightNum(searchRefundChangeSignRequest.getFlightNum());
        searchRefundChangeSignParam.setCabin(searchRefundChangeSignRequest.getCabin());
        searchRefundChangeSignParam.setDpt(searchRefundChangeSignRequest.getDpt());
        searchRefundChangeSignParam.setArr(searchRefundChangeSignRequest.getArr());
        searchRefundChangeSignParam.setDptDate(searchRefundChangeSignRequest.getDptDate().replace("-", ""));
        searchRefundChangeSignParam.setDptTime(searchRefundChangeSignRequest.getDptTime());
        searchRefundChangeSignParam.setPolicyId(searchRefundChangeSignRequest.getPolicyId());
        searchRefundChangeSignParam.setMaxSellPrice(searchRefundChangeSignRequest.getMaxSellPrice());
        searchRefundChangeSignParam.setMinSellPrice(searchRefundChangeSignRequest.getMinSellPrice());
        searchRefundChangeSignParam.setPrintPrice(searchRefundChangeSignRequest.getPrintPrice());
        searchRefundChangeSignParam.setTagName(searchRefundChangeSignRequest.getTagName());
        searchRefundChangeSignParam.setTranslate(searchRefundChangeSignRequest.isTranslate());
        searchRefundChangeSignParam.setSfid(searchRefundChangeSignRequest.getSfid());
        searchRefundChangeSignParam.setNeedPercentTgqText(searchRefundChangeSignRequest.isNeedPercentTgqText());
        searchRefundChangeSignParam.setBusinessExt(searchRefundChangeSignRequest.getBusinessExt());
        searchRefundChangeSignParam.setClient(searchRefundChangeSignRequest.getClient());
        return searchRefundChangeSignParam;
    }
}
