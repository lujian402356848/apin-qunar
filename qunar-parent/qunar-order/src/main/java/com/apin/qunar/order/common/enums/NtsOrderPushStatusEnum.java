package com.apin.qunar.order.common.enums;

/**
 * @outhor lujian
 * @create 2018-07-27 9:34
 */
public enum NtsOrderPushStatusEnum {
    INIT(0, "初始状态"),
    BOOK_OK(2, "订座成功等待支付"),
    PAY_OK(4, "支付成功等待出票"),
    TICKET_OK(5, "出票完成"),
    TICKET_FAIL(6, "出票失败"),
    CANCEL_OK(7, "订单取消");

    NtsOrderPushStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public final int code;
    public final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
