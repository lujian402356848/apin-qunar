package com.apin.qunar.order.common.enums;

public enum OrderShowEnum {
    NOSHOW(0, "不显示"),
    SHOW(1, "显示");

    private int status;
    private String desc;

    OrderShowEnum(int status, String desc) {
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
