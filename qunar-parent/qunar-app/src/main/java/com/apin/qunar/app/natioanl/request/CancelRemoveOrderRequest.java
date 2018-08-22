package com.apin.qunar.app.natioanl.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CancelRemoveOrderRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
    @NotEmpty(message = "account不能为空")
    private String account;
}
