package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-07-04 15:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsSearchRefundChangeSignRequest extends BaseRequest {
    @NotEmpty(message = "pricekey不能为空")
    private String pricekey;
    private String passengerType;
    private String planeType;
}