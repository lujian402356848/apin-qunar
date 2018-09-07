package com.apin.qunar.order.common.enums;

public enum ReturnStatusEnum {
    NO_RETURN(0, "未退款"),
    RETURNING(1, "退款中"),
    RETURN_SUCCESS(2, "退款成功");


    private int status;
    private String desc;

    ReturnStatusEnum(int status, String desc) {
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
