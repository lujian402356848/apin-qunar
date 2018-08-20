package com.apin.qunar.order.common.enums;

public enum VoucherTypeEnum {


    XCD(1, "行程单"),
    INVOICE(2, "发票");

    VoucherTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static VoucherTypeEnum valueOfEnum(String desc) {
        switch (desc) {
            case "行程单":
                return XCD;
            case "发票":
                return INVOICE;
        }
        return XCD;
    }

    public final int code;
    public final String desc;
}


