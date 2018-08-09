package com.apin.qunar.order.common.enums;

public enum CabinTypeEnum {
    HEAD(1, "头等舱/商务舱"),
    ECONOMIC(2, "经济舱");

    CabinTypeEnum(int code, String desc) {
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
