package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 8:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchFlightRequest extends BaseRequest {
    @NotEmpty(message = "depCity不能为空")
    private String depCity;
    @NotEmpty(message = "arrCity不能为空")
    private String arrCity;
    @NotEmpty(message = "depDate不能为空")
    private String depDate;
    private String retDate;
    private Integer adultNum;
    private Integer childNum;
    private String cabinLevel;
    /**
     * 排序标识，ui使用
     */
    private Integer sortIdentification;
    private String account;

    /**
     * 二次筛选的起飞时间.
     */
    private List<List<String>> takeoffTime;

    /**
     * 起飞机场
     */
    private String takeoffAirport;

    /**
     * 航空公司.
     */
    private String airlineCompany;
}
