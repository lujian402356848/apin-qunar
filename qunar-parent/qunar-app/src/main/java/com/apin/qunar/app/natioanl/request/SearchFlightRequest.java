package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author fy
 * @version 2018-08-06 16:49
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchFlightRequest extends BaseRequest {
    /**
     * 起飞机场三字码.
     */
    private String dpt;

    /**
     * 到达机场三字码.
     */
    private String arr;

    /**
     * 起飞日期.
     */
    private String date;

    /**
     * 报价类型。<报价类型默认为youxuan></>
     */
    private String exTrack;

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


