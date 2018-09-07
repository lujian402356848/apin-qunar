package com.apin.qunar.order.domain.international.searchPrice;

import lombok.Data;

/**
 * Created by zhuangxiong on 17-11-1.
 */
@Data
public class NtsSearchPriceParam {
    private String depCity;
    private String arrCity;
    private String depDate;
    private String retDate;
    private String source;
    private String flightCode;
    private Integer adultNum;
    private Integer childNum;
    private String cabinLevel;
}
