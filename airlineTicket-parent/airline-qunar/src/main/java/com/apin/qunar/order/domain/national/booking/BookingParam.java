package com.apin.qunar.order.domain.national.booking;


import lombok.Data;

/**
 * Created by wjjunjjun.wang on 2017/7/26.
 */
@Data
public class BookingParam {
    private String ticketPrice;
    private String barePrice;
    private String price;
    private String basePrice;
    private String businessExt;
    private String tag;
    private String carrier;
    private String flightNum;
    private String cabin;
    private String from;
    private String to;
    private String policyId;
    private String policyType;
    private String wrapperId;
    private String groupId;
    private String startTime;
    private String client;
    private String dptTime;
    private String flightType;
    private String userName;
}
