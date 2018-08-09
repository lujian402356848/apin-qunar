package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-06-27 16:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchOrderListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    private String account;
    private String orderNo;
    private String pessengerName;
}
