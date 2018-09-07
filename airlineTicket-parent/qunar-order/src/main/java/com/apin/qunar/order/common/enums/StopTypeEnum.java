package com.apin.qunar.order.common.enums;

public enum StopTypeEnum {
    DIRECT(1, "直飞"),
    STOP_OVER(2, "经停"),
    TRANSFER(3, "中转"),
    UNKNOWN(4, "未知");

    StopTypeEnum(int code, String desc) {
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
