package com.apin.qunar.order.common.enums;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
public enum AgeTypeEnum {

    ADULT(0, "成人"),
    CHILD(1, "儿童");

    AgeTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AgeTypeEnum valueOfEnum(String desc) {
        switch (desc) {
            case "成人":
                return ADULT;
            case "儿童":
                return CHILD;
        }
        return ADULT;
    }

    public final int code;
    public final String desc;
}
