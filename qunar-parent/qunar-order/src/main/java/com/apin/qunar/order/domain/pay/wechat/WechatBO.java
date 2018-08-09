package com.apin.qunar.order.domain.pay.wechat;

import lombok.Data;

@Data
public class WechatBO {
    private String merchantNo;
    private String orderNo;
    private Integer totalAmount;
    private boolean hasInlandOrder;
    private String ip;
}

