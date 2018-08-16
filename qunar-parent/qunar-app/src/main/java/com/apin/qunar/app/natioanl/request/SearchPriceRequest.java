package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Created by wjjunjjun.wang on 2017/7/24.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchPriceRequest extends BaseRequest {
    @NotEmpty(message = "dpt不能为空")
    private String dpt;
    @NotEmpty(message = "arr不能为空")
    private String arr;
    @NotEmpty(message = "date不能为空")
    private String date;
    @NotEmpty(message = "carrier不能为空")
    private String carrier;
    @NotEmpty(message = "flightNum不能为空")
    private String flightNum;
    private String cabin;
    @NotEmpty(message = "exTrack不能为空")
    private String exTrack;
}
