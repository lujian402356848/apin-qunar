package com.apin.qunar.order.domain.international.flightChange;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-26 22:24
 */
@Data
public class NtsFlightChangeCallbackDTO {
    private Long id;
    private String orderNo;
    private String flightNo;
    private String dptDate;
    private String dptAirport;
    private String arrAirport;
    private String dptTime;
    private String arrTime;
    private String folFlightNo;
    private String folDptDate;
    private String folArrDate;
    private String folDptTime;
    private String folArrTime;
    private String folDptAirport;
    private String folArrAirport;
    private String folFptTower;
    private String folArrTower;
    private String smsContent;
    private String status;
    private Long notifyId;
    private String initStatus;
    private int ensure;
    private String airLineTel;
    private String fcStatus;
}