package com.apin.qunar.order.common.enums;

public enum PayChannelEnum {
    ALIPAY(1, "支付宝"),
    WECHAT(2, "微信");

    private int status;
    private String desc;

    PayChannelEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
