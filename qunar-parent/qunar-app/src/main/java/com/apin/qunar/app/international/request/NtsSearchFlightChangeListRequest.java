package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-27 9:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchFlightChangeListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
}