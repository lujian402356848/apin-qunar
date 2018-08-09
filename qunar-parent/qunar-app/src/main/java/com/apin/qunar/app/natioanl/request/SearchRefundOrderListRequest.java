package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor ligang
 * @create 2018-07-27 18:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchRefundOrderListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    private String account;
    private String orderNo;
    private String pessengerName;
}
