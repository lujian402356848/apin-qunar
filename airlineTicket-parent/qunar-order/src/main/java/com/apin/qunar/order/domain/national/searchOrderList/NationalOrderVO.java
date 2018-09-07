package com.apin.qunar.order.domain.national.searchOrderList;

import lombok.Data;

import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-07-02 17:23
 */
@Data
public class NationalOrderVO {
    private Long id;
    private String orderNo;
    private String ticketNo;
    private String clientSite;
    private String flightNum;
    private String actFlightNum;
    private String flightTime;
    private String carrierCode;
    private String carrierName;
    private Integer stopCnt;
    private String deptCity;
    private String arriCity;
    private String deptAirportCode;
    private String arriAirportCode;
    private String deptAirportName;
    private String arriAirportName;
    private String deptTerminal;
    private String arriTerminal;
    private String deptDate;
    private String deptTime;
    private String arriTime;
    private Integer fuelTax;
    private Integer constructionFee;
    private Integer returnFee;
    private String returnText;
    private Integer changeFee;
    private String changeText;
    private Integer printPrice;
    private Integer publishPrice;
    private String passengers;
    private String payId;
    private Integer payAmount;
    private Integer payStatus;
    private String payTime;
    private String payErrorMsg;
    private String contactName;
    private String contactNum;
    private String contactMobile;
    private String contactEmail;
    private Date insertTime;
    private Date updateTime;
}
