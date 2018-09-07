package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = true)
public class NtsBookingRequest extends BaseRequest {
    @NotEmpty(message = "priceKey不能为空")
    private String priceKey;
}
