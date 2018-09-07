package com.apin.qunar.app.pay.request.alipay;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @outhor lujian
 * @create 2018-07-31 22:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryAlipayRequest extends BaseRequest {
    private String outTradeNo;
}