package com.apin.qunar.order.domain.national.searchFlight;

import lombok.Data;

import java.util.List;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Data
public class SearchFlightResultVO {
    private int total;
    private List<FlightInfo> flightInfos;
}
