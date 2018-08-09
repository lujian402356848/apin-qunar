package com.apin.qunar.order.common.enums;

/**
 * @outhor lujian
 * @create 2018-08-01 6:39
 */
public enum  QunarPayStatusEnum {
    NO_PAY(0, "未支付"),
    PAY_FAIL(1, "支付失败"),
    PAY_SUCCESS(2, "支付成功");

    private int status;
    private String desc;

    QunarPayStatusEnum(int status, String desc) {
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
