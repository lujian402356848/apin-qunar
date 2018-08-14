package com.apin.qunar.order.domain.international.searchFlight;

import lombok.Data;

import java.util.List;

/**
 * Created by zhuangxiong on 17-10-26.
 */
@Data
public class NtsSearchFlightParam {
    private String depCity;
    private String arrCity;
    private String depDate;
    private String retDate;
    private String source;
    private Integer adultNum;
    private Integer childNum;
    private String cabinLevel;
    private Integer sortIdentification;
}
