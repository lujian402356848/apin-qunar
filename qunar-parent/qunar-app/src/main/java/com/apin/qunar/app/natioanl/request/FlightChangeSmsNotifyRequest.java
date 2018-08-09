package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-27 17:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FlightChangeSmsNotifyRequest extends BaseRequest {
    private String orderNo;
}