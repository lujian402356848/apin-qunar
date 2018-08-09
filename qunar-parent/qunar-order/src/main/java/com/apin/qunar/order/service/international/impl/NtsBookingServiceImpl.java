package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.booking.NtsBookingParam;
import com.apin.qunar.order.domain.international.booking.NtsBookingResultVO;
import com.apin.qunar.order.service.international.NtsBookingService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class NtsBookingServiceImpl extends NtsApiService<NtsBookingParam, ApiResult<NtsBookingResultVO>> implements NtsBookingService {

    private final SimpleDateFormat sdfSource = new SimpleDateFormat("yyyyMMddHHmm");//输入格式
    private final SimpleDateFormat sdfTarget = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //转化为目标格式
    @Autowired
    private MerchantPriceConfigService merchantPriceConfigService;

    @Override
    protected String getTag() {
        return "flight.international.supply.sl.bk";
    }

    @Override
    protected TypeReference<ApiResult<NtsBookingResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<NtsBookingResultVO>>() {
        };
    }

    @Override
    public ApiResult<NtsBookingResultVO> booking(final NtsBookingParam ntsBookingParam, final String merchantNo) {
        ApiResult<NtsBookingResultVO> apiResult = execute(ntsBookingParam);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (apiResult.isSuccess()) {
            formatTime(apiResult.getResult());
        }
//        setPrice(apiResult.getResult(), merchantNo);//预定航班接口 加价
        return apiResult;
//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), NtsBookingResultVO.class));
    }

    private void setPrice(NtsBookingResultVO ntsBookingResultVO, String merchantNo) {
        double ratio = merchantPriceConfigService.queryPriceRatio(merchantNo, false);
        NtsBookingResultVO.PriceInfo priceInfo = ntsBookingResultVO.getPriceInfo();
        int adultPrice = (int) (priceInfo.getAdultPrice() * ratio);
        int childPrice = (int) (priceInfo.getChildPrice() * ratio);
        priceInfo.setAdultPrice(adultPrice);
        priceInfo.setChildPrice(childPrice);
    }

    public void formatTime(NtsBookingResultVO apiResults) {
        String departDateTime = null;
        String[] departDateTimeSplit = null;
        String arriveDateTime = null;
        String[] arriveDateTimeSplit = null;
        try {
            List<NtsBookingResultVO.Segment> segmentList = apiResults.getSegments();
            for (NtsBookingResultVO.Segment segment : segmentList) {
                departDateTime = sdfTarget.format(sdfSource.parse(segment.getDepartTime()));
                departDateTimeSplit = departDateTime.split(" ");
                segment.setDepartDate(departDateTimeSplit[0]);
                segment.setDepartTime(departDateTimeSplit[1]);
                arriveDateTime = sdfTarget.format(sdfSource.parse(segment.getArriveTime()));
                arriveDateTimeSplit = arriveDateTime.split(" ");
                segment.setArriveDate(arriveDateTimeSplit[0]);
                segment.setArriveTime(arriveDateTimeSplit[1]);
            }
        } catch (ParseException e) {
            log.error("国际订单预定日期格式化异常,result:{}", JSON.toJSON(apiResults));
        }
    }
}
