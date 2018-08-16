package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Created by wjjunjjun.wang on 2017/7/26.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookingRequest extends BaseRequest {
    @NotEmpty(message = "vendorStr不能为空")
    private String vendorStr;
    @NotEmpty(message = "from不能为空")
    private String from;
    @NotEmpty(message = "to不能为空")
    private String to;
    @NotEmpty(message = "flightNum不能为空")
    private String flightNum;
    @NotEmpty(message = "startTime不能为空")
    private String startTime;
    @NotEmpty(message = "carrier不能为空")
    private String carrier;
    @NotEmpty(message = "dptTime不能为空")
    private String dptTime;
}