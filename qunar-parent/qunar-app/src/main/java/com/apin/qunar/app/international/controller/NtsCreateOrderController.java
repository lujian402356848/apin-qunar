package com.apin.qunar.app.international.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.international.request.NtsCreateOrderRequest;
import com.apin.qunar.basic.dao.model.Country;
import com.apin.qunar.basic.service.CountryService;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.international.booking.NtsBookingParam;
import com.apin.qunar.order.domain.international.booking.NtsBookingResultVO;
import com.apin.qunar.order.domain.international.createOrder.*;
import com.apin.qunar.order.service.international.NtsBookingService;
import com.apin.qunar.order.service.international.NtsCreateOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
 * @create 2018-07-02 19:34
 * 创建订单
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class NtsCreateOrderController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private NtsBookingService ntsBookingService;
    @Autowired
    private NtsCreateOrderService ntsCreateOrderService;
    @Autowired
    private CountryService countryService;

    @PostMapping(value = "/ntsOrder/create")
    public GeneralResultMap createOrder(@Valid @RequestBody NtsCreateOrderRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
//        if (!generalResultMap.isSuccess()) {
//            log.warn("/ntsOrder/create接口基础验证不通过，request:{}", JSON.toJSON(request));
//            return generalResultMap;
//        }

        try {
            ApiResult<NtsBookingResultVO> ntsBookingResult = ntsBookingService.booking(buildNtsBookingParam(request), request.getMerchantNo());
            if (ntsBookingResult.isSuccess()) {//如果预定成功，则判断座位数是否大于0
                if (ntsBookingResult.getResult() != null && ntsBookingResult.getResult().getMaxSeats() > 0) {
                    ApiResult<NtsCreateOrderResultVO> ntsOrderResult = ntsCreateOrderService.createOrder(buildNtsCreateOrderRequestBO(request), buildNtsCreateOrderParam(ntsBookingResult.getResult(), request), ntsBookingResult.getResult());
                    if (ntsOrderResult.isSuccess()) {
                        generalResultMap.setResult(SysReturnCode.SUCC, ntsOrderResult.getResult());
                    } else {
                        generalResultMap.setResult(ntsOrderResult.getCode(), ntsOrderResult.getMessage());
                    }
                } else {
                    generalResultMap.setResult(SysReturnCode.FAIL, "座位数为0，不可预订！");
                }
            } else {
                generalResultMap.setResult(ntsBookingResult.getCode(), ntsBookingResult.getMessage());
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.error("国际生成订单异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    private NtsBookingParam buildNtsBookingParam(final NtsCreateOrderRequest createOrderRequest) {
        NtsBookingParam ntsBookingParam = new NtsBookingParam();
        ntsBookingParam.setPriceKey(createOrderRequest.getBookingTagKey());
        ntsBookingParam.setSource(orderConfig.getInternationalSource());
        return ntsBookingParam;
    }

    private NtsCreateOrderParam buildNtsCreateOrderParam(final NtsBookingResultVO ntsBookingResult, final NtsCreateOrderRequest ntsCreateOrderRequest) {
        NtsCreateOrderParam ntsCreateOrderParam = new NtsCreateOrderParam();
        ntsCreateOrderParam.setSource(orderConfig.getInternationalSource());
        ntsCreateOrderParam.setBookingTagKey(ntsBookingResult.getBookingTagKey());

        ntsCreateOrderParam.setContact(ntsCreateOrderRequest.getContact());
        ntsCreateOrderParam.setPassengerList(ntsCreateOrderRequest.getPassengerList());
        setCountryCode(ntsCreateOrderParam);
        ntsCreateOrderParam.setXcd(ntsCreateOrderRequest.getXcd());
        if (ntsCreateOrderParam.getXcd() == null) {
            Xcd xcd = new Xcd();
            xcd.setReimburseType(0);
            ntsCreateOrderParam.setXcd(xcd);
        }
        return ntsCreateOrderParam;
    }

    private void setCountryCode(NtsCreateOrderParam ntsCreateOrderParam) {
        List<Passenger> passengerList = ntsCreateOrderParam.getPassengerList();
        Country country = null;
        for (Passenger passenger : passengerList) {
            country = countryService.queryLikeByName(passenger.getCardIssuePlace());
            if (country != null) {
                passenger.setCardIssuePlace(country.getCode());
            }
            country = countryService.queryLikeByName(passenger.getNationality());
            if (country != null) {
                passenger.setNationality(country.getCode());
            }
        }
    }

    private NtsCreateOrderRequestBO buildNtsCreateOrderRequestBO(NtsCreateOrderRequest request) {
        return BeanUtil.copyProperties(request, NtsCreateOrderRequestBO.class);
    }
}