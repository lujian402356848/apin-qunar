package com.apin.qunar.app.natioanl.request.payFailOrder;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class SearchPayFailOrderListRequest extends BaseRequest {
    private String orderNo;
    private String startTime;
    private String endTime;
    private Integer offset;
    private Integer limit;
}
