package com.apin.qunar.order.domain.national.searchFlight;

import lombok.Data;

/**
 * Created by wangliang.wang on 2017/8/1.
 */
@Data
public class FlightInfo {

    private String dpt;
    private String arr;
    private String dptAirport;
    private String dptTerminal;
    private String arrAirport;
    private String arrTerminal;
    private String dptTime;
    private String arrTime;
    private String flightNum;
    private String barePrice;
    private String carrier;
    private String carrierName;
    private String flightTimes;
    private String flightTypeFullName;
    private String tag;
    private boolean codeShare;
    private String actFlightNum;
    private String stop;
    private String stopsNum;
    private String stopCityCode;
    private String stopCityName;
    private String stopAirportCode;
    private String stopAirportName;
    private String stopAirportFullName;
}
