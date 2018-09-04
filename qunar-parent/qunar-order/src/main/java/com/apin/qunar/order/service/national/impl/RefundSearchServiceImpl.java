package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchParam;
import com.apin.qunar.order.domain.national.refundSearch.RefundSearchResultVO;
import com.apin.qunar.order.service.national.RefundSearchService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-23 22:18
 */
@Slf4j
@Service
public class RefundSearchServiceImpl extends ApiService<RefundSearchParam, ApiResult<List<RefundSearchResultVO>>> implements RefundSearchService {
    @Override
    protected String getTag() {
        return "flight.national.supply.sl.refundSearch";
    }

    @Autowired
    private MerchantPriceConfigService merchantPriceConfigService;

    @Override
    protected TypeReference<ApiResult<List<RefundSearchResultVO>>> getTypeReference() {
        return new TypeReference<ApiResult<List<RefundSearchResultVO>>>() {
        };
    }

    @Override
    public ApiResult<List<RefundSearchResultVO>> refundSearch(final RefundSearchParam refundSearchParam, final String merchantNo) {
        ApiResult<List<RefundSearchResultVO>> apiResult = execute(refundSearchParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
//        setPrice(apiResult.getResult(), merchantNo);
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), RefundSearchResultVO.class));
    }

    private void setPrice(List<RefundSearchResultVO> refundSearchResultVOS, String merchantNo) {
        double ratio = merchantPriceConfigService.queryAddPrice(merchantNo, true);
        for (RefundSearchResultVO refundSearchResultVO : refundSearchResultVOS) {
            List<RefundSearchResultVO.TgqReason> tgqReasons = refundSearchResultVO.getRefundSearchResult().getTgqReasons();
            for (RefundSearchResultVO.TgqReason tgqReason : tgqReasons) {
                List<RefundSearchResultVO.RefundPassengerPriceInfo> refundPassengerPriceInfos = tgqReason.getRefundPassengerPriceInfoList();
                for (RefundSearchResultVO.RefundPassengerPriceInfo refundPassengerPriceInfo : refundPassengerPriceInfos) {
                    double refundFee = refundPassengerPriceInfo.getRefundFeeInfo().getRefundFee() * ratio;
                    refundPassengerPriceInfo.getRefundFeeInfo().setRefundFee((int) refundFee);
                }
            }
        }
    }
}
