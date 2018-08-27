package com.apin.qunar.order.common.enums;

public enum CouponStatusEnum {
    UNUSED("0", "未使用"),
    USED("1", "已使用"),
    EXPIRED("2", "已过期");

    CouponStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public final String code;
    public final String desc;
}
