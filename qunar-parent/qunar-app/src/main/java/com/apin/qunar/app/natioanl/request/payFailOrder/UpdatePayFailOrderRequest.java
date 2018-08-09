package com.apin.qunar.app.natioanl.request.payFailOrder;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdatePayFailOrderRequest extends BaseRequest {
    private String orderNo;
    private Integer status;
    private String desc;
    private Integer payAmount;
    private String operator;
}