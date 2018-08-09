package com.apin.qunar.order.common.enums;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
public enum  AgeTypeEnum {

    ADULT(0, "成人"),
    CHILD(1, "儿童");

    AgeTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public final int code;
    public final String desc;
}
