package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.dao.model.AirlinePriceRate;
import com.apin.qunar.basic.service.AirlinePriceRateService;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.Vendor;
import com.apin.qunar.order.domain.national.searchPrice.SearchPriceParam;
import com.apin.qunar.order.domain.national.searchPrice.SearchPriceResultVO;
import com.apin.qunar.order.service.national.SearchPriceService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class SearchPriceServiceImpl extends ApiService<SearchPriceParam, ApiResult<SearchPriceResultVO>> implements SearchPriceService {

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.searchprice";
    }

    @Autowired
    private AirlinePriceRateService airlinePriceRateService;

    @Override
    protected TypeReference<ApiResult<SearchPriceResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SearchPriceResultVO>>() {
        };
    }

    @Override
    public ApiResult<SearchPriceResultVO> searchPrice(final SearchPriceParam searchPriceParam, final String merchantNo) {
        ApiResult<SearchPriceResultVO> apiResult = execute(searchPriceParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国内航班报价异常,param:{},原因:{}", JSON.toJSON(searchPriceParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), apiResult.getMessage());
        }
        sortByPrice(apiResult.getResult());
        setPrice(apiResult.getResult());
        return apiResult;
    }

    private void sortByPrice(SearchPriceResultVO searchPriceResultVO) {
        if (CollectionUtils.isNotEmpty(searchPriceResultVO.getVendors())) {
            List<Vendor> sortVendors = searchPriceResultVO.getVendors().stream().sorted(Comparator.comparing(Vendor::getBarePrice)).collect(Collectors.toList());
            searchPriceResultVO.setVendors(sortVendors);
        }
    }

    private void setPrice(SearchPriceResultVO searchPriceResultVO) {
        if (CollectionUtils.isEmpty(searchPriceResultVO.getVendors())) {
            return;
        }
        AirlinePriceRate priceRate = null;
        List<Vendor> vendors = searchPriceResultVO.getVendors();
        for (Vendor vendor : vendors) {
            priceRate = airlinePriceRateService.queryByCode(searchPriceResultVO.getCarrier(), vendor.getCabin());
            if (priceRate != null && priceRate.getPosition().equalsIgnoreCase(vendor.getCabin())) {
                vendor.setPriceRateTag(priceRate.getPriceRate() + "折");
            }
        }
    }
}