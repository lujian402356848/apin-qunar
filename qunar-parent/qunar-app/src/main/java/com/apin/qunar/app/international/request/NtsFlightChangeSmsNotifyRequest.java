package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-31 9:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsFlightChangeSmsNotifyRequest extends BaseRequest {
    private String orderNo;
}
