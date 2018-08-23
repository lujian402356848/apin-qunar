package com.apin.qunar.app.pay.request.wechat;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WechatPayRefundRequest extends BaseRequest {
    private String orderNo;
    private String parentNo;
    private Integer refundAmount;
    private Integer totalAmount;

}
