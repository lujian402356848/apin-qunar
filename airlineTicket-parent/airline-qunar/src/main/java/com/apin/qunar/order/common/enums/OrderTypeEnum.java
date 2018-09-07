package com.apin.qunar.order.common.enums;

public enum OrderTypeEnum {
    COMMON(1, "【普通订单"),
    CHANGE(2, "改签订单");

    OrderTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


}
