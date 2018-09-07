package com.apin.qunar.statistics.common.enums;

public enum GoBackTypeEnum {
    DEPT(1, "出发地"),
    ARRI(2, "目的地");

    GoBackTypeEnum(int code, String desc) {
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
