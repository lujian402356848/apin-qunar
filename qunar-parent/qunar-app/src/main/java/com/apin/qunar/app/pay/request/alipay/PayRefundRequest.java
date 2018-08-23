package com.apin.qunar.app.pay.request.alipay;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PayRefundRequest extends BaseRequest {
    private String orderNo;
    private Integer totalAmount;
}
