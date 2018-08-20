package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor ligang
 * @create 2018-08-20 17:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchReimburseVoucherListRequest extends BaseRequest {
    private Integer offset;
    private Integer limit;
    private String orderNo;
}
