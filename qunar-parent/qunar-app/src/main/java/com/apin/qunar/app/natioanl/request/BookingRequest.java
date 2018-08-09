package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by wjjunjjun.wang on 2017/7/26.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookingRequest extends BaseRequest {
    private String vendorStr;
    private String from;
    private String to;
    private String flightNum;
    private String startTime;
    private String carrier;
    private String dptTime;
}