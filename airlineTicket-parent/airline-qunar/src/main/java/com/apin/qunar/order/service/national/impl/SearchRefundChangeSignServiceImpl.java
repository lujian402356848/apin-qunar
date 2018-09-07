package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.searchRefundChangeSign.SearchRefundChangeSignParam;
import com.apin.qunar.order.domain.national.searchRefundChangeSign.SearchRefundChangeSignResultVO;
import com.apin.qunar.order.service.national.SearchRefundChangeSignService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-27 17:21
 */
@Service
public class SearchRefundChangeSignServiceImpl extends ApiService<SearchRefundChangeSignParam, ApiResult<SearchRefundChangeSignResultVO>> implements SearchRefundChangeSignService {
    @Override
    protected String getTag() {
        return "flight.national.supply.sl.tgqNew";
    }

    @Autowired
    private MerchantPriceConfigService merchantPriceConfigService;

    @Override
    protected TypeReference<ApiResult<SearchRefundChangeSignResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SearchRefundChangeSignResultVO>>() {
        };
    }

    @Override
    public ApiResult<SearchRefundChangeSignResultVO> searchRefundChangeSign(final SearchRefundChangeSignParam searchRefundChangeSignParam, final String merchantNo) {
        ApiResult<SearchRefundChangeSignResultVO> apiResult = execute(searchRefundChangeSignParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
//        setPrice(apiResult.getResult(), merchantNo);
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), SearchRefundChangeSignResultVO.class));
    }

//    private void setPrice(SearchRefundChangeSignResultVO searchRefundChangeSignResultVO, String merchantNo) {
//        double ratio = merchantPriceConfigService.queryPriceRatio(merchantNo, true);
//        List<SearchRefundChangeSignResultVO.TgqPointCharge> TgqPointCharges = searchRefundChangeSignResultVO.getTgqPointCharges();
//        for (SearchRefundChangeSignResultVO.TgqPointCharge tgqPointCharge : TgqPointCharges) {
//            int returnFee = (int) (tgqPointCharge.getReturnFee() * ratio);
//            tgqPointCharge.setReturnFee(returnFee);
//        }
//    }
}
