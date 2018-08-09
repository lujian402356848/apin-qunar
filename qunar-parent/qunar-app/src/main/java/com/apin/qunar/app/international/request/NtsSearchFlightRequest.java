package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 8:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchFlightRequest extends BaseRequest {
    private String depCity;
    private String arrCity;
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
