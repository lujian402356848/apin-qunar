package com.apin.qunar.order.domain.national.searchPrice;

import com.apin.qunar.order.domain.national.booking.Vendor;
import lombok.Data;

import java.util.List;

/**
 * Created by wangliang.wang on 2017/7/26.
 */
@Data
public class SearchPriceResult {
    private String date;
    private String depCode;
    private String arrCode;
    private String code;
    private String carrier;
    private String btime;
    private boolean meal;
    private int arf;
    private int tof;
    private int distance;
    private String flightType;
    private List<Vendor> vendors;
}
