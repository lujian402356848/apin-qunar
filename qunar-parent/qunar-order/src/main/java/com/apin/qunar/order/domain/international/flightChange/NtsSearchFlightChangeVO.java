package com.apin.qunar.order.domain.international.flightChange;

import lombok.Data;

import java.util.Date;

/**
 * @outhor lujian
 * @create 2018-07-27 8:37
 */
@Data
public class NtsSearchFlightChangeVO {
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
    private String changeStatus;
    private Integer hasSendSms;
    private Date insertTime;
}
