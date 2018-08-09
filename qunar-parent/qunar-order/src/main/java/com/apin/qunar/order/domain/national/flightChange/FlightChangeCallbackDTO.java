package com.apin.qunar.order.domain.national.flightChange;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-26 15:32
 */
@Data
public class FlightChangeCallbackDTO {
    private String orderNo;
    private String flightNo;
    private String dptDate;
    private String dptTime;
    private String arrTime;
    private String dptAirPort;
    private String arrAirPort;
    private String folFlightNo;
    private String folDptDate;
    private String folDptTime;
    private String folArrTime;
    private String folDptAirPort;
    private String folArrAirPort;
    private String changeStatus;
}
