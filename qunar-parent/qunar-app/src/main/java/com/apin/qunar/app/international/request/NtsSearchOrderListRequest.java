package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-09 13:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchOrderListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    private String account;
    private String orderNo;
    private String pessengerName;
}
