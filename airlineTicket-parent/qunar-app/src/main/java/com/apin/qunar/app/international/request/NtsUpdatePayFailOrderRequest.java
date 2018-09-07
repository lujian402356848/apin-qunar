package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = true)
public class NtsUpdatePayFailOrderRequest extends BaseRequest {
    @NotEmpty(message = "orderNo不能为空")
    private String orderNo;
    private Integer status;
    private String desc;
    private Integer payAmount;
    private String account;
}