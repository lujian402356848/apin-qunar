package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NtsCancelRemoveOrderRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
    @NotEmpty(message = "account不能为空")
    private String account;
}