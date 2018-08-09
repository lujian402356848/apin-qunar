package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-04 15:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchRefundChangeSignRequest extends BaseRequest {
    private String pricekey;
    private String passengerType;
    private String planeType;
}