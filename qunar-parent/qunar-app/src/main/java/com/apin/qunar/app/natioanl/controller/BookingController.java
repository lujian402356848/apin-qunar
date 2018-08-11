package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.BookingRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.utils.JacksonUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.constant.Constants;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.BookingParam;
import com.apin.qunar.order.domain.national.booking.BookingResultVO;
import com.apin.qunar.order.domain.national.booking.Vendor;
import com.apin.qunar.order.service.national.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-07-02 19:34
 * 预定
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class BookingController extends BaseController {

    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/order/booking")
    public GeneralResultMap booking(@RequestBody BookingRequest request) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/booking接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Vendor vendor = JacksonUtil.decode(request.getVendorStr(), Vendor.class);
        try {
            ApiResult<BookingResultVO> apiResult = bookingService.booking(buildBookingParam(request, vendor));
            if (apiResult.isSuccess()) {
                generalResultMap.setResult(SysReturnCode.SUCC, apiResult.getResult());
            } else {
                generalResultMap.setResult(SysReturnCode.FAIL,"航班信息发生变更，请重新搜索");
            }
        } catch (Exception e) {
            log.info("预定国内订单异常,request:{}", request, e);
        }
        return generalResultMap;
    }

    private BookingParam buildBookingParam(BookingRequest bookingRequest, Vendor vendor) {
        BookingParam bookingParam = new BookingParam();
        bookingParam.setBarePrice(String.valueOf(vendor.getBarePrice()));
        bookingParam.setTicketPrice(String.valueOf(vendor.getVppr()));
        bookingParam.setBasePrice(String.valueOf(vendor.getBasePrice()));
        bookingParam.setPrice(String.valueOf(vendor.getPrice()));
        bookingParam.setBusinessExt(vendor.getBusinessExt());
        bookingParam.setCabin(vendor.getCabin());
        bookingParam.setPolicyId(vendor.getPolicyId());
        bookingParam.setPolicyType(vendor.getPolicyType());
        bookingParam.setGroupId(String.valueOf(vendor.getGroupId()));
        bookingParam.setWrapperId(vendor.getWrapperId());
        bookingParam.setClient(vendor.getDomain());

        bookingParam.setStartTime(bookingRequest.getStartTime().replace("-", ""));
        bookingParam.setDptTime(bookingRequest.getDptTime().replace(":", ""));
        bookingParam.setCarrier(bookingRequest.getCarrier());
        bookingParam.setFlightNum(bookingRequest.getFlightNum());
        bookingParam.setFrom(bookingRequest.getFrom());
        bookingParam.setTo(bookingRequest.getTo());
        bookingParam.setWrapperId(vendor.getWrapperId());
        bookingParam.setFlightType(String.valueOf(Constants.ONE_WAY));       //固定1 表示单程
        bookingParam.setUserName(orderConfig.getUserName());
        bookingParam.setTag(vendor.getBarePrice() > 0 ? vendor.getBprtag() : vendor.getPrtag());
//        bookingParam.setIncomePrice(vendor.getIncomePrice());
        return bookingParam;
    }
}
