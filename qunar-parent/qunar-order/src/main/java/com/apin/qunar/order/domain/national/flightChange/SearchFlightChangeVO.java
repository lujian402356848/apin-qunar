package com.apin.qunar.order.domain.national.flightChange;

import lombok.Data;

import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-07-27 8:37
 */
@Data
public class SearchFlightChangeVO {
    private String orderNo;
    private String flightNo;
    private String dptDate;
    private String dptTime;
    private String arrTime;
    private String dptAirport;
    private String arrAirport;
    private String folFlightNo;
    private String folDptDate;
    private String folDptTime;
    private String folArrTime;
    private String folDptAirport;
    private String folArrAirport;
    private String changeStatus;
    private Integer hasSendSms;
    private Date insertTime;
}
