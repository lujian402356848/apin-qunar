package com.apin.qunar.order.common.enums;

public enum OrderCountryEnum {
    international(0, "国际"),
    internal(1, "国内");

    private int status;
    private String desc;

    OrderCountryEnum(int status, String desc) {
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
