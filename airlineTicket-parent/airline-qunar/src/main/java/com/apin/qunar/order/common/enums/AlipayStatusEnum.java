package com.apin.qunar.order.common.enums;

/**
 * @outhor lujian
 * @create 2018-07-31 19:58
 */
public enum AlipayStatusEnum {
    NO_PAY(0, "未支付"),
    PAYING(1, "支付中"),
    PAY_SUCCESS(2, "支付成功");

    private int status;
    private String desc;

    AlipayStatusEnum(int status, String desc) {
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
