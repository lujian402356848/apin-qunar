package com.apin.qunar.basic.common.enums;

/**
 * @outhor lujian
 * @create 2018-07-25 19:04
 */
public enum PayAccountStausEnum {
    NOSIGN(1, "未签约，未绑定"),
    SIGN(2, "已签约，已绑定");

    PayAccountStausEnum(int code, String desc) {
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
