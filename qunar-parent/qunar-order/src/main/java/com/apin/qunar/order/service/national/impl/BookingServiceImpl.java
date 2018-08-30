package com.apin.qunar.order.service.national.impl;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.basic.service.impl.ResponseResult;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.BookingParam;
import com.apin.qunar.order.domain.national.booking.BookingResultVO;
import com.apin.qunar.order.service.national.BookingService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class BookingServiceImpl extends ApiService<BookingParam, ApiResult<BookingResultVO>> implements BookingService {

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.bk";
    }

    @Override
    protected TypeReference<ApiResult<BookingResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<BookingResultVO>>() {
        };
    }

    @Override
    public ApiResult<BookingResultVO> booking(final BookingParam bookingParam) {
        ResponseResult responseResult = null;
        ApiResult<BookingResultVO> apiResult = execute(bookingParam, responseResult);
        if (apiResult == null) {
            return ApiResult.fail();
        }
        if (!apiResult.isSuccess()) {
            log.warn("查询国内booking异常,param:{},url:{},原因:{}", JSON.toJSON(bookingParam), responseResult == null ? "" : responseResult.getUrl(), apiResult.getMessage());
            return ApiResult.fail(apiResult.getCode(), "航班价格发生变更，请重新搜索");
        }
        setTgqPercentText(apiResult.getResult());
        return apiResult;
    }

    private void setTgqPercentText(BookingResultVO bookingResultVO) {
        if (bookingResultVO == null || bookingResultVO.getTgqShowData() == null) {
            return;
        }
        if (StringUtils.isNotBlank(bookingResultVO.getTgqShowData().getTgqText())) {
            bookingResultVO.getTgqShowData().setTgqText(bookingResultVO.getTgqShowData().getTgqText().replaceAll("<br />", " "));
        }
        if (StringUtils.isNotBlank(bookingResultVO.getTgqShowData().getTgqPercentText())) {
            bookingResultVO.getTgqShowData().setTgqPercentText(bookingResultVO.getTgqShowData().getTgqPercentText().replaceAll("<br />", " "));
        }
    }
}