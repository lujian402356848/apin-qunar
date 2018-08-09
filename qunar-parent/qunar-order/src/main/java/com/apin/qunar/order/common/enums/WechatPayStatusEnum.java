package com.apin.qunar.order.common.enums;

public enum WechatPayStatusEnum {
    NO_PAY(0, "未支付"),
    PAYING(1, "支付中"),
    PAY_SUCCESS(2, "支付成功");

    private int status;
    private String desc;

    WechatPayStatusEnum(int status, String desc) {
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
