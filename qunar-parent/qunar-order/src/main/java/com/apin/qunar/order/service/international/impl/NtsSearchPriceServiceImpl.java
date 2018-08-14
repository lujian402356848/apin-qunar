package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.order.common.redis.NtsFlightPriceRedis;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceParam;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceResultVO;
import com.apin.qunar.order.service.international.NtsSearchPriceService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class NtsSearchPriceServiceImpl extends NtsApiService<NtsSearchPriceParam, ApiResult<NtsSearchPriceResultVO>> implements NtsSearchPriceService {
    @Resource
    private NtsFlightPriceRedis ntsFlightPriceRedis;

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.pricesearch";
    }

    @Override
    protected TypeReference<ApiResult<NtsSearchPriceResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsSearchPriceResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsSearchPriceResultVO> searchPrice(final NtsSearchPriceParam ntsPriceSearchParam, final String merchantNo) {
        ApiResult<NtsSearchPriceResultVO> apiResult = execute(ntsPriceSearchParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        NtsSearchPriceResultVO ntsSearchPriceResult = apiResult.getResult();
        if (!apiResult.isSuccess()) {
            log.warn("查询国际航班报价异常,param:{},原因:{}", JSON.toJSON(ntsPriceSearchParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), "航班信息发生变动，请重新搜索");
        }
        ntsSearchPriceResult.setPriceInfo(ntsSearchPriceResult.getPriceInfo().stream().sorted(Comparator.comparing(NtsSearchPriceResultVO.PriceInfo::getPrice)).collect(Collectors.toList()));
//        ntsFlightPriceRedis.setFlightPriceInfo(ntsPriceSearchParam, ntsSearchPriceResult);
        changePackName(ntsSearchPriceResult);
        return apiResult;
    }
    private void changePackName(NtsSearchPriceResultVO ntsSearchPriceResultVO) {
        List<NtsSearchPriceResultVO.PriceInfo> priceInfos = ntsSearchPriceResultVO.getPriceInfo();
        for(NtsSearchPriceResultVO.PriceInfo priceInfo : priceInfos)
        {
            switch (priceInfo.getPackName())
            {
                case "去哪儿自营" :
                    priceInfo.setPackName("爱拼自营");
                    break;
                case "商旅套餐" :
                    priceInfo.setPackName("爱拼惠盈");
                    break;
                case "商务舱" :
                    priceInfo.setPackName("爱拼商务舱");
                    break;
                case "低价特惠" :
                    priceInfo.setPackName("爱拼国际特优");
                    break;
                case "低价专享" :
                    priceInfo.setPackName("爱拼国际包优");
                    break;
                case "头等舱" :
                    priceInfo.setPackName("爱拼头等舱");
                    break;
                case "旗舰店" :
                    priceInfo.setPackName("爱拼旗舰店");
                    break;
                case "去哪儿旗舰店" :
                    priceInfo.setPackName("爱拼旗舰店");
                    break;
                default:
                    break;
            }
        }
    }
}
