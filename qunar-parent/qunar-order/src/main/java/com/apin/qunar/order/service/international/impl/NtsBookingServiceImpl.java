package com.apin.qunar.order.service.international.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.service.MerchantPriceConfigService;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.booking.NtsBookingParam;
import com.apin.qunar.order.domain.international.booking.NtsBookingResultVO;
import com.apin.qunar.order.service.international.NtsBookingService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        if (!apiResult.isSuccess()) {
            log.warn("查询国际booking异常,param:{},原因:{}", JSON.toJSON(ntsBookingParam), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), "航班价格发生变更，请重新搜索");
        }
        formatTime(apiResult.getResult());
        formatString(apiResult.getResult());
        return apiResult;
    }

    private void formatString(NtsBookingResultVO apiResults) {
        NtsBookingResultVO.TgqRule tgqRule = apiResults.getTgqRule();
        if (tgqRule == null) {
            return;
        }
        if (StringUtils.isNotBlank(tgqRule.getBaggage())) {
            tgqRule.setBaggage(tgqRule.getBaggage().replaceAll("去哪儿", "爱拼机"));
        }
        if (StringUtils.isNotBlank(tgqRule.getChange())) {
            tgqRule.setChange(tgqRule.getChange().replaceAll("去哪儿", "爱拼机"));
        }
        if (StringUtils.isNotBlank(tgqRule.getOther())) {
            tgqRule.setOther(tgqRule.getOther().replaceAll("去哪儿", "爱拼机"));
        }
        if (StringUtils.isNotBlank(tgqRule.getRefund())) {
            tgqRule.setRefund(tgqRule.getRefund().replaceAll("去哪儿", "爱拼机"));
        }
    }

    private void formatTime(NtsBookingResultVO apiResults) {
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
