package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-06-25 8:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchPriceRequest extends BaseRequest {
    private String depCity;
    private String arrCity;
    private String depDate;
    private String retDate;
    private String flightCode;
    private Integer adultNum;
    private Integer childNum;
    private String cabinLevel;
}
