package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SearchRegularPassengerListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    private String name;
    private String account;
}
