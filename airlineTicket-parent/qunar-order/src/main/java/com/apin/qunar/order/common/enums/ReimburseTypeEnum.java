package com.apin.qunar.order.common.enums;

public enum ReimburseTypeEnum {


    XCD(1, "行程单和差额发票");

    ReimburseTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ReimburseTypeEnum valueOfEnum(String desc) {
        switch (desc) {
            case "行程单和差额发票":
                return XCD;
        }
        return XCD;
    }

    public final int code;
    public final String desc;
}


