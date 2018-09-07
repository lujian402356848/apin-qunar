package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-07-27 9:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchFlightChangeListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    private String account;
}