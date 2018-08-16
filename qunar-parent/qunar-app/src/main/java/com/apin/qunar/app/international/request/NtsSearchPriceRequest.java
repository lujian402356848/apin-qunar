package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-06-25 8:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchPriceRequest extends BaseRequest {
    @NotEmpty(message = "depCity不能为空")
    private String depCity;
    @NotEmpty(message = "arrCity不能为空")
    private String arrCity;
    @NotEmpty(message = "depDate不能为空")
    private String depDate;
    private String retDate;
    @NotEmpty(message = "flightCode不能为空")
    private String flightCode;
    private Integer adultNum;
    private Integer childNum;
    private String cabinLevel;
}
