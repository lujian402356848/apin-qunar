package com.apin.qunar.order.common.enums;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
public enum CardTypeEnum {

    IDENTIFICATION_CARD("NI", "身份证"),
    PASSPORT("PP", "护照"),
    OTHER("ID", "其它");

    CardTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public final String code;
    public final String desc;
}
