package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.SearchPriceRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.Vendor;
import com.apin.qunar.order.domain.national.searchPrice.SearchPriceParam;
import com.apin.qunar.order.domain.national.searchPrice.SearchPriceResultVO;
import com.apin.qunar.order.service.national.SearchPriceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-02 16:49
 * 查询报价
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class SearchPriceController extends BaseController {
    @Autowired
    private SearchPriceService searchPriceService;

    @PostMapping(value = "/search/price")
    public GeneralResultMap searchPrice(@RequestBody@Valid SearchPriceRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/search/price接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        try {
            ApiResult<SearchPriceResultVO> apiResult = searchPriceService.searchPrice(buildSearchPriceParam(request), request.getMerchantNo());
            if (apiResult.isSuccess()) {
                processVendors(apiResult.getResult());
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(apiResult.getCode(),"航班信息变动，请重新搜索");
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国内查询价格信息异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private void processVendors(SearchPriceResultVO searchPriceResult) {
        List<Vendor> vendorList = searchPriceResult.getVendors();
        if (CollectionUtils.isNotEmpty(vendorList)) {
            for (Vendor vendor : vendorList) {
                vendor.setTag(buildTag(vendor));
            }
        }
    }

    private String buildTag(Vendor vendor) {
        return vendor.getBarePrice() > 0 ? vendor.getBprtag() : vendor.getPrtag();
    }

    private SearchPriceParam buildSearchPriceParam(final SearchPriceRequest searchPriceRequest) {
        SearchPriceParam searchPriceParam = new SearchPriceParam();
        searchPriceParam.setDpt(searchPriceRequest.getDpt());
        searchPriceParam.setArr(searchPriceRequest.getArr());
        searchPriceParam.setDate(searchPriceRequest.getDate());
        searchPriceParam.setCarrier(searchPriceRequest.getCarrier());
        searchPriceParam.setFlightNum(searchPriceRequest.getFlightNum());
        searchPriceParam.setCabin(searchPriceRequest.getCabin());
        searchPriceParam.setEx_track("youxuan");
        return searchPriceParam;
    }
}