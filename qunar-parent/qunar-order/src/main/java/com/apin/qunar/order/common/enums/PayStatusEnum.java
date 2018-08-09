package com.apin.qunar.order.common.enums;

public enum PayStatusEnum {
    WAIT_BUYER_PAY(1, "交易创建，等待买家付款"),
    TRADE_CLOSED(2, "未付款交易超时关闭，或支付完成后全额退款"),
    TRADE_SUCCESS(3, "交易支付成功"),
    TRADE_FINISHED(4, "交易结束，不可退款"),
    ERROR_FEE(5, "交易金额不正确"),
    FAILD_DEAL(6, "失败"),
    UNKNOWN_STATE(7, "未知状态码"),
    QUNAR_SUCCESS(8, "去哪儿支付成功"),
    QUNAR_FAILD(9, "去哪儿支付失败");

/*    CALLBACK_ONLY(3, "已回调，但不代表成功"),
    CALLBACK_VALIDATE_FAIL(4, "已回调，但签名验证失败"),
    CALLBACK_VALIDATE_SUCCESS(5, "已回调，且签名验证成功"),*/


    private int status;
    private String name;

    PayStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}