package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchPayFailOrderRequest extends BaseRequest {
    private String orderNo;
    private String startTime;
    private String endTime;
    private Integer offset;
    private Integer limit;
}