package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by wjjunjjun.wang on 2017/7/24.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchPriceRequest extends BaseRequest {
    private String dpt;
    private String arr;
    private String date;
    private String carrier;
    private String flightNum;
    private String cabin;
    private String exTrack;
}
