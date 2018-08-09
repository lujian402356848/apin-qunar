package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-06-25 6:49
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchOrderDetailRequest extends BaseRequest {
    private String orderNo;
}
