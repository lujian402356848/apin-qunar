package com.apin.qunar.order.domain.international.createOrder;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-07-27 6:14
 */
@Data
public class NtsCreateOrderRequestBO {
    private String merchantNo;//商户号
    /*去*/
    private String bookingTagKey;
    private String depCityName;//出发城市名
    private String arrCityName;//到达城市名
    private String depTerminal;//出发航站楼
    private String arrTerminal;//到达航站楼
    private String depAirportName;//出发机场名称
    private String arrAirportName;//到达机场名称
    private String carrierCode;//航空公司编号
    private String carrierFullName;//航空公司全名
    private String duration;//飞行时间
    /*回*/
    private String backDepCityName;//出发城市名
    private String backArrCityName;//到达城市名
    private String backDepTerminal;//出发航站楼
    private String backArrTerminal;//到达航站楼
    private String backDepAirportName;//出发机场名称
    private String backArrAirportName;//到达机场名称
    private String backCarrierCode;//航空公司编号
    private String backCarrierFullName;//航空公司全名
    private String backDuration;//飞行时间
    private List<Passenger> passengerList;
    private Contact contact;
    private Xcd xcd;
    private String account;
    private String packName;
}
