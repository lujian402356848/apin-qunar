package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.BookingParam;
import com.apin.qunar.order.domain.national.booking.BookingResultVO;
import com.apin.qunar.order.domain.national.booking.PackageInfo;
import com.apin.qunar.order.service.national.BookingService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Service
public class BookingServiceImpl extends ApiService<BookingParam, ApiResult<BookingResultVO>> implements BookingService {

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.bk";
    }

    @Autowired
    private MerchantPriceConfigService merchantPriceConfigService;

    @Override
    protected TypeReference<ApiResult<BookingResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<BookingResultVO>>() {
        };
    }

    @Override
    public ApiResult<BookingResultVO> booking(final BookingParam bookingParam) {
        ApiResult<BookingResultVO> apiResult = execute(bookingParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        apiResult.setResult(buildTgq(apiResult.getResult()));
//        setPrice(apiResult.getResult(), bookingParam.getIncomePrice());//预定航班接口 加价
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), BookingResultVO.class));
    }

    private void setPrice(BookingResultVO bookingResultVO, Integer incomePrice) {
        Map<String, List<PackageInfo>> priceTag = bookingResultVO.getPriceInfo().getPriceTag();
        for (Map.Entry<String, List<PackageInfo>> packageInfoMap : priceTag.entrySet()) {
            List<PackageInfo> packageInfos = packageInfoMap.getValue();
            for (PackageInfo packageInfo : packageInfos) {
                int viewPrice = (int) packageInfo.getViewPrice() + incomePrice;
                int barePrice = (int) packageInfo.getBarePrice() + incomePrice;
                packageInfo.setViewPrice(viewPrice);
                packageInfo.setBarePrice(barePrice);
            }
        }
//        bookingResultVO.getPriceInfo().setIncomePrice(incomePrice);
    }

    private BookingResultVO buildTgq(BookingResultVO bookingResultVO) {
        if(Objects.nonNull(bookingResultVO.getTgqShowData())) {
            if (StringUtils.isNotBlank(bookingResultVO.getTgqShowData().getTgqText())) {
                bookingResultVO.getTgqShowData().setTgqText(bookingResultVO.getTgqShowData().getTgqText().replaceAll("<br />", " "));
            }
            if (StringUtils.isNotBlank(bookingResultVO.getTgqShowData().getTgqPercentText())) {
                bookingResultVO.getTgqShowData().setTgqPercentText(bookingResultVO.getTgqShowData().getTgqPercentText().replaceAll("<br />", " "));
            }
        }
        return bookingResultVO;
    }
}