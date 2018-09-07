package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.order.common.config.OrderConfig;
import com.apin.qunar.order.dao.impl.NationalOrderDaoImpl;
import com.apin.qunar.order.service.national.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AutoCreateOrderServiceImpl implements AutoCreateOrderService {
    @Autowired
    private NationalOrderDaoImpl nationalOrderDao;
    @Autowired
    private SearchPriceService searchPriceService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CreateOrderService createOrderService;
    @Autowired
    private PayService payService;
    @Autowired
    private OrderConfig orderConfig;

//    public boolean createOrder(String orderNo) {
//        boolean result = false;
//        NationalOrder nationalOrder = nationalOrderDao.queryByOrderNo(orderNo);
//        if (nationalOrder = null) {
//            log.warn("数据库中没有找到该订单【{}】", orderNo);
//            return result;
//        }
//        ApiResult<SearchPriceResultVO> searchPriceResult = searchPriceService.searchPrice(buildSearchPriceParam(nationalOrder), nationalOrder.getMerchantNo());
//        ApiResult<BookingResultVO> bookingResult =  bookingService.booking(buildBookingParam(nationalOrder, searchPriceResult.getResult()));
//        createOrderService.createOrder(bookingResult.getResult());
//    }
//    private CreateOrderRequestBO buildCreateOrderRequestBO(CreateOrderRequest createOrderRequest) {
//        CreateOrderRequestBO createOrderRequestBO = BeanUtil.copyProperties(createOrderRequest, CreateOrderRequestBO.class);
//        List<CreateOrderRequestBO.Passenger> passengers = BeanUtil.copyProperties(createOrderRequest.getPassengers(), CreateOrderRequestBO.Passenger.class);
//        createOrderRequestBO.setPassengers(passengers);
//        return createOrderRequestBO;
//    }
//
//    private CreateOrderParam buildCreateOrderParam(){
//        CreateOrderParam createOrderParam=new CreateOrderParam();
//        createOrderParam.setAddress();
//    }
//
//    CreateOrderParam createOrderParam = new CreateOrderParam();
//    BookingPriceInfo priceInfo = bookingResult.getPriceInfo();
//    BookingFlightInfo bookingFlightInfo = bookingResult.getFlightInfo().get(0);
//    ExtInfo extInfo = bookingResult.getExtInfo();
//
//        createOrderParam.setProductTag(extInfo.getTag());
//        createOrderParam.setFuelTax(Integer.parseInt(bookingFlightInfo.getTof()));
//        createOrderParam.setChildFuelTax(Integer.parseInt(bookingFlightInfo.getCtof()));
//        createOrderParam.setConstructionFee(Integer.parseInt(bookingFlightInfo.getArf()));
//        createOrderParam.setBookingTag(bookingResult.getBookingTag());
//        createOrderParam.setQt(extInfo.getQt());
//        createOrderParam.setClientSite(extInfo.getClientId());
//
//        createOrderParam.setPrintPrice((int) priceInfo.getPriceTag().get("ADU").get(0).getViewPrice());
//        createOrderParam.setyPrice(Integer.parseInt(priceInfo.getTicketPrice()));
//        createOrderParam.setDiscount((int) Double.parseDouble(priceInfo.getDiscount()) * 10);
//        createOrderParam.setFlyFund(false);//不支持
//        createOrderParam.setUseBonus(false);//不支持
//        createOrderParam.setPolicyId(Long.valueOf(extInfo.getPolicyId()));
//        createOrderParam.setPolicyType(Integer.valueOf(extInfo.getPolicyType()));
//        createOrderParam.setSource(orderConfig.getNatioanlSource());
//
//    //联系人信息
//        createOrderParam.setContact(createOrderRequest.getContact());
//        createOrderParam.setContactPreNum(createOrderRequest.getContactPreNum());  //这里添区域码  我这里默认写中国的了
//        createOrderParam.setContactMob(createOrderRequest.getContactMob());
//        createOrderParam.setContactEmail(createOrderRequest.getContactEmail());
//
//    //不可少  传空串,这是用来接收去哪儿的短信等信息
//        if (StringUtils.isBlank(createOrderRequest.getSjr())) {
//        createOrderParam.setSjr("郑小龙");
//    } else {
//        createOrderParam.setSjr(createOrderRequest.getSjr());
//    }
//        if (StringUtils.isBlank(createOrderRequest.getSjrPhone())) {
//        createOrderParam.setSjrPhone("15221762156");
//    } else {
//        createOrderParam.setSjrPhone(createOrderRequest.getSjrPhone());
//    }
//        createOrderParam.setBxInvoice(createOrderRequest.getNeedInvoice());//有发票为1,没发票为空
//        if ("1".equals(createOrderRequest.getNeedInvoice())) {//如果需要发票，则填写发票相关信息
//        createOrderParam.setInvoiceType(createOrderRequest.getInvoiceType());
//        createOrderParam.setReceiverType(createOrderRequest.getReceiverType());
//        createOrderParam.setReceiverTitle(createOrderRequest.getReceiverTitle());
//    }
//    //乘机人信息，写一个人测试使用
//        createOrderParam.setPassengerCount(createOrderRequest.getPassengers().size()); //这里填实际的乘机人数
//        createOrderParam.setPassengers(buildPassenger(createOrderRequest, priceInfo));
//
//    //行程单部分
//        createOrderParam.setXcd(createOrderRequest.isNeedXcd() ? "1" : "");
//        createOrderParam.setXcdMethod(createOrderRequest.isNeedXcd() ? "8" : "");   //若需要行程单则写死"8"
//        createOrderParam.setXcdPrice(createOrderRequest.isNeedXcd() ? bookingResult.getExpressInfo().getPrice() : 0);
//        createOrderParam.setAddress(createOrderRequest.isNeedXcd() ? createOrderRequest.getAddress() : "");
//
//    //航班信息
//        createOrderParam.setFlightInfo(buildFlightInfo(bookingFlightInfo));
//
//        return createOrderParam;
//
//    private SearchPriceParam buildSearchPriceParam(final NationalOrder nationalOrder) {
//        SearchPriceParam searchPriceParam = new SearchPriceParam();
//        searchPriceParam.setDpt(nationalOrder.getDeptCode());
//        searchPriceParam.setArr(nationalOrder.getArriCode());
//        searchPriceParam.setDate(nationalOrder.getDeptDate());
//        searchPriceParam.setCarrier(nationalOrder.getCarrierCode());
//        searchPriceParam.setFlightNum(nationalOrder.getFlightNum());
//        searchPriceParam.setCabin(nationalOrder.getCabin());
//        searchPriceParam.setEx_track("youxuan");
//        return searchPriceParam;
//    }
//
//    private BookingParam buildBookingParam(NationalOrder nationalOrder, SearchPriceResultVO result) {
//        BookingParam bookingParam = new BookingParam();
//        bookingParam.setBarePrice(String.valueOf(result.getBarePrice()));
//        if (CollectionUtils.isEmpty(result.getVendors())) {
//            return null;
//        }
//        Vendor vendor = result.getVendors().get(0);
//        bookingParam.setTicketPrice(String.valueOf(vendor.getVppr()));
//        bookingParam.setBasePrice(String.valueOf(vendor.getBasePrice()));
//        bookingParam.setPrice(String.valueOf(vendor.getPrice()));
//        bookingParam.setBusinessExt(vendor.getBusinessExt());
//        bookingParam.setCabin(vendor.getCabin());
//        bookingParam.setPolicyId(vendor.getPolicyId());
//        bookingParam.setPolicyType(vendor.getPolicyType());
//        bookingParam.setGroupId(String.valueOf(vendor.getGroupId()));
//        bookingParam.setWrapperId(vendor.getWrapperId());
//        bookingParam.setClient(vendor.getDomain());
//
//        bookingParam.setStartTime(nationalOrder.getDeptDate().replace("-", ""));
//        bookingParam.setDptTime(nationalOrder.getDeptTime().replace(":", ""));
//        bookingParam.setCarrier(nationalOrder.getCarrierCode());
//        bookingParam.setFlightNum(nationalOrder.getFlightNum());
//        bookingParam.setFrom(nationalOrder.getDeptCode());
//        bookingParam.setTo(nationalOrder.getArriCode());
//        bookingParam.setWrapperId(vendor.getWrapperId());
//        bookingParam.setFlightType(String.valueOf(Constants.ONE_WAY));//固定1 表示单程
//        bookingParam.setUserName(orderConfig.getUserName());
//        bookingParam.setTag(vendor.getBarePrice() > 0 ? vendor.getBprtag() : vendor.getPrtag());
//        return bookingParam;
//    }
}
