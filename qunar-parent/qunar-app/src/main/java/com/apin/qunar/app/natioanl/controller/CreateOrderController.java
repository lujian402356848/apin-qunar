package com.apin.qunar.app.natioanl.controller;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.natioanl.request.CreateOrderRequest;
import com.apin.qunar.common.enums.SysReturnCode;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.common.utils.JacksonUtil;
import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.common.constant.Constants;
import com.apin.qunar.order.common.enums.AgeTypeEnum;
import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.national.booking.*;
import com.apin.qunar.order.domain.national.createOrder.*;
import com.apin.qunar.order.service.national.BookingService;
import com.apin.qunar.order.service.national.CreateOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @outhor lujian
 * @create 2018-06-23 22:29
 * 创建订单
 */

@Slf4j
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class CreateOrderController extends BaseController {
    @Autowired
    private OrderConfig orderConfig;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping(value = "/order/create")
    public GeneralResultMap createOrder(@RequestBody @Valid CreateOrderRequest request, BindingResult bindingResult) {
        GeneralResultMap generalResultMap = validateCommonParam(request);
        if (!generalResultMap.isSuccess()) {
            log.warn("/order/create接口基础验证不通过，request:{}", JSON.toJSON(request));
            return generalResultMap;
        }
        Map<String, Object> data = new HashMap<>();
        try {
            Vendor vendor = JacksonUtil.decode(request.getVendorStr(), Vendor.class);
            ApiResult<BookingResultVO> bookingResult = bookingService.booking(buildBookingParam(request, vendor));
            if (bookingResult.isSuccess()) {//如果预定成功，则校验乘客人数是否足够
                String validateResult = validatePassenger(request, bookingResult.getResult());
                if (StringUtils.isBlank(validateResult)) {
                    CreateOrderParam createOrderParam = buildCreateOrderParam(bookingResult.getResult(), request);
                    ApiResult<CreateOrderResultVO> createOrderResult = createOrderService.createOrder(buildCreateOrderRequestBO(request), createOrderParam, bookingResult.getResult());
                    if (createOrderResult.isSuccess()) {
                        data.put("createOrderResult", createOrderResult.getResult());
                        data.put("clientSite", bookingResult.getResult().getExtInfo().getClientId());
                        generalResultMap.setResult(SysReturnCode.SUCC, data);
                    } else {
                        generalResultMap.setResult(createOrderResult.getCode(), createOrderResult.getMessage());
                    }
                } else {
                    generalResultMap.setResult(SysReturnCode.FAIL, validateResult);
                }
            } else {
                generalResultMap.setResult(bookingResult.getCode(), "航班价格发生变更，请重新搜索");
            }
        } catch (Exception e) {
            generalResultMap.setResult(SysReturnCode.FAIL);
            log.info("国内创建订单异常,request:{}", JSON.toJSON(request), e);
        }
        return generalResultMap;
    }

    private String validatePassenger(CreateOrderRequest createOrderRequest, BookingResultVO bookingResult) {
        String adultCountStr = bookingResult.getPriceInfo().getInventory().getAdult();
        if (StringUtils.isNotBlank(adultCountStr) && "a".equalsIgnoreCase(adultCountStr)) {
            return "";
        }
        long adultCount = createOrderRequest.getPassengers().size();
        long bookingAdultCount = Long.parseLong(adultCountStr);
        if (bookingAdultCount < adultCount) {
            return String.format("票数不足，最多可预订%s人", bookingAdultCount);
        }
        boolean isExistChild = createOrderRequest.getPassengers().stream().anyMatch(p -> p.getAgeType() == AgeTypeEnum.CHILD.code);
        if (isExistChild && bookingResult.getPriceInfo().getPriceTag().get("CHI") == null) {//说明该航班不支持儿童，但是UI传入儿童票
            return "该航班不支持儿童票，请重新选择";
        }
        return "";
    }

    private BookingParam buildBookingParam(CreateOrderRequest orderRequest, Vendor vendor) {
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

        bookingParam.setStartTime(orderRequest.getStartTime().replace("-", ""));
        bookingParam.setDptTime(orderRequest.getDptTime().replace(":", ""));
        bookingParam.setCarrier(orderRequest.getCarrier());
        bookingParam.setFlightNum(orderRequest.getFlightNum());
        bookingParam.setFrom(orderRequest.getFrom());
        bookingParam.setTo(orderRequest.getTo());
        bookingParam.setWrapperId(vendor.getWrapperId());
        bookingParam.setFlightType(String.valueOf(Constants.ONE_WAY));//固定1 表示单程
        bookingParam.setUserName(orderConfig.getUserName());
        bookingParam.setTag(vendor.getBarePrice() > 0 ? vendor.getBprtag() : vendor.getPrtag());

        return bookingParam;
    }

    private CreateOrderParam buildCreateOrderParam(BookingResultVO bookingResult, CreateOrderRequest createOrderRequest) {
        CreateOrderParam createOrderParam = new CreateOrderParam();
        BookingPriceInfo priceInfo = bookingResult.getPriceInfo();
        BookingFlightInfo bookingFlightInfo = bookingResult.getFlightInfo().get(0);
        ExtInfo extInfo = bookingResult.getExtInfo();

        createOrderParam.setProductTag(extInfo.getTag());
        createOrderParam.setFuelTax(Integer.parseInt(bookingFlightInfo.getTof()));
        createOrderParam.setChildFuelTax(Integer.parseInt(bookingFlightInfo.getCtof()));
        createOrderParam.setConstructionFee(Integer.parseInt(bookingFlightInfo.getArf()));
        createOrderParam.setBookingTag(bookingResult.getBookingTag());
        createOrderParam.setQt(extInfo.getQt());
        createOrderParam.setClientSite(extInfo.getClientId());

        createOrderParam.setPrintPrice((int) priceInfo.getPriceTag().get("ADU").get(0).getViewPrice());
        createOrderParam.setyPrice(Integer.parseInt(priceInfo.getTicketPrice()));
        createOrderParam.setDiscount((int) Double.parseDouble(priceInfo.getDiscount()) * 10);
        createOrderParam.setFlyFund(false);//不支持
        createOrderParam.setUseBonus(false);//不支持
        createOrderParam.setPolicyId(Long.valueOf(extInfo.getPolicyId()));
        createOrderParam.setPolicyType(Integer.valueOf(extInfo.getPolicyType()));
        createOrderParam.setSource(orderConfig.getNatioanlSource());

        //联系人信息
        createOrderParam.setContact(createOrderRequest.getContact());
        createOrderParam.setContactPreNum(createOrderRequest.getContactPreNum());  //这里添区域码  我这里默认写中国的了
        createOrderParam.setContactMob(createOrderRequest.getContactMob());
        createOrderParam.setContactEmail(createOrderRequest.getContactEmail());

        //不可少  传空串,这是用来接收去哪儿的短信等信息
        if (StringUtils.isBlank(createOrderRequest.getSjr())) {
            createOrderParam.setSjr("郑小龙");
        } else {
            createOrderParam.setSjr(createOrderRequest.getSjr());
        }
        if (StringUtils.isBlank(createOrderRequest.getSjrPhone())) {
            createOrderParam.setSjrPhone("15221762156");
        } else {
            createOrderParam.setSjrPhone(createOrderRequest.getSjrPhone());
        }
        createOrderParam.setBxInvoice(createOrderRequest.getNeedInvoice());//有发票为1,没发票为空
        if ("1".equals(createOrderRequest.getNeedInvoice())) {//如果需要发票，则填写发票相关信息
            createOrderParam.setInvoiceType(createOrderRequest.getInvoiceType());
            createOrderParam.setReceiverType(createOrderRequest.getReceiverType());
            createOrderParam.setReceiverTitle(createOrderRequest.getReceiverTitle());
        }
        createOrderParam.setPassengerCount(createOrderRequest.getPassengers().size()); //这里填实际的乘机人数
        createOrderParam.setPassengers(buildPassenger(createOrderRequest, priceInfo));

        //行程单部分
        createOrderParam.setXcd(createOrderRequest.isNeedXcd() ? "1" : "");
        createOrderParam.setXcdMethod(createOrderRequest.isNeedXcd() ? "8" : "");   //若需要行程单则写死"8"
        createOrderParam.setXcdPrice(createOrderRequest.isNeedXcd() ? bookingResult.getExpressInfo().getPrice() : 0);
        createOrderParam.setAddress(createOrderRequest.isNeedXcd() ? createOrderRequest.getAddress() : "");

        //航班信息
        createOrderParam.setFlightInfo(buildFlightInfo(bookingFlightInfo));

        return createOrderParam;
    }

    private List<Passenger> buildPassenger(CreateOrderRequest createOrderRequest, BookingPriceInfo priceInfo) {
        List<Passenger> passengers = new ArrayList<>();
        List<CreateOrderRequest.Passenger> passengerDTOs = createOrderRequest.getPassengers();
        for (CreateOrderRequest.Passenger passengerDTO : passengerDTOs) {
            Passenger passenger = new Passenger();
            passenger.setName(passengerDTO.getName());
            passenger.setAgeType(passengerDTO.getAgeType());       //0成人    1儿童
            passenger.setCardType(passengerDTO.getCardType());    //NI:身份证,PP:护照,ID:其他
            passenger.setCardNo(passengerDTO.getCardNo());
            passenger.setSex(passengerDTO.getSex());//性别,1:男,0:女
            passenger.setBirthday(passengerDTO.getBirthday());  //非身份证乘机人   必传生日    格式：1993-08-11，统一加上生日(卢建)
            //请注意此处的获取方式
            if (passengerDTO.getAgeType() == AgeTypeEnum.ADULT.code) {
                passenger.setPassengerPriceTag(priceInfo.getPriceTag().get("ADU").get(0).getTag());
            } else {//如果是儿童的话
                passenger.setPassengerPriceTag(priceInfo.getPriceTag().get("CHI").get(0).getTag());
            }
            passengers.add(passenger);
        }
        return passengers;
    }

    private FlightInfo buildFlightInfo(BookingFlightInfo bookingFlightInfo) {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setFlightNum(bookingFlightInfo.getFlightNum());
        flightInfo.setFlightType(Constants.ONE_WAY);    //现在只有单程 写死1
        flightInfo.setStopInfo(bookingFlightInfo.getStops());
        flightInfo.setDeptAirportCode(bookingFlightInfo.getDpt());
        flightInfo.setArriAirportCode(bookingFlightInfo.getArr());
        flightInfo.setDeptCity(bookingFlightInfo.getDptCity());
        flightInfo.setArriCity(bookingFlightInfo.getArrCity());
        flightInfo.setDeptDate(bookingFlightInfo.getDptDate());
        flightInfo.setDeptTime(bookingFlightInfo.getDptTime().replace(":", ""));
        flightInfo.setArriTime(bookingFlightInfo.getArrTime().replace(":", ""));
        flightInfo.setCabin(bookingFlightInfo.getCabin());
        flightInfo.setChildCabin(bookingFlightInfo.getChildCabin() == null ? "Y" : bookingFlightInfo.getChildCabin());
        return flightInfo;
    }

    private CreateOrderRequestBO buildCreateOrderRequestBO(CreateOrderRequest createOrderRequest) {
        CreateOrderRequestBO createOrderRequestBO = BeanUtil.copyProperties(createOrderRequest, CreateOrderRequestBO.class);
        List<CreateOrderRequestBO.Passenger> passengers = BeanUtil.copyProperties(createOrderRequest.getPassengers(), CreateOrderRequestBO.Passenger.class);
        createOrderRequestBO.setPassengers(passengers);
        return createOrderRequestBO;
    }
}