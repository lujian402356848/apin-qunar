package com.apin.qunar.order.common.enums;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
public enum SexTypeEnum {

    FEMALE(0, "女性"),
    MALE(1, "男性");

    SexTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public final int code;
    public final String desc;
}
