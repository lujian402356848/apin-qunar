package com.apin.qunar.basic.domain.airport;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-18 13:19
 */
@Data
public class AirportVO {
    private String airportCode;
    private String airportName;
    private String completeSpell;
    private String shortSpell;
    private String cityName;
}