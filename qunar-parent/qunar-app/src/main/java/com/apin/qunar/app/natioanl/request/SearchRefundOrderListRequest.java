package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor ligang
 * @create 2018-07-27 18:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchRefundOrderListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    @NotEmpty(message = "account不能为空")
    private String account;
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
    @NotEmpty(message = "pessengerName不能为空")
    private String pessengerName;
}
