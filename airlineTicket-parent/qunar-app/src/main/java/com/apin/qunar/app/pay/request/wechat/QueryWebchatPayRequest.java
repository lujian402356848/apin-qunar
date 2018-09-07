package com.apin.qunar.app.pay.request.wechat;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class QueryWebchatPayRequest extends BaseRequest {
    private String outTradeNo;
}