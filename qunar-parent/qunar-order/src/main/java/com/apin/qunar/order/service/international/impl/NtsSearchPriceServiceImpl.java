package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceParam;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceResultVO;
import com.apin.qunar.order.service.international.NtsSearchPriceService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
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
public class NtsSearchPriceServiceImpl extends NtsApiService<NtsSearchPriceParam, ApiResult<NtsSearchPriceResultVO>> implements NtsSearchPriceService {

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.pricesearch";
    }

    @Autowired
    private MerchantPriceConfigService merchantPriceConfigService;

    @Override
    protected TypeReference<ApiResult<NtsSearchPriceResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsSearchPriceResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsSearchPriceResultVO> searchPrice(final NtsSearchPriceParam ntsPriceSearchParam, final String merchantNo) {
        ApiResult<NtsSearchPriceResultVO> apiResult = execute(ntsPriceSearchParam);
        NtsSearchPriceResultVO ntsSearchPriceResult = apiResult.getResult();
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国际航班报价异常,param:{},原因:{}", JSON.toJSON(ntsPriceSearchParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(),"航班信息发生变动，请重新搜索");
        }
        ntsSearchPriceResult.setPriceInfo(ntsSearchPriceResult.getPriceInfo().stream().sorted(Comparator.comparing(NtsSearchPriceResultVO.PriceInfo::getPrice)).collect(Collectors.toList()));
        return apiResult;
    }

    private void setPrice(NtsSearchPriceResultVO ntsSearchPriceResult, String merchantNo) {
        double ratio = merchantPriceConfigService.queryPriceRatio(merchantNo, false);
        List<NtsSearchPriceResultVO.PriceInfo> priceInfos = ntsSearchPriceResult.getPriceInfo();
        for (NtsSearchPriceResultVO.PriceInfo priceInfo : priceInfos) {
            int priceAfter = (int) (priceInfo.getPrice() * ratio);
            priceInfo.setPrice(priceAfter);
        }
    }

}
