package com.apin.qunar.order.common.enums;

/**
 * @outhor lujian
 * @create 2018-06-27 21:03
 * 国内订单状态
 */
public enum OrderStatusEnum {
    BOOK_OK(0, "订座成功等待支付"),
    PAY_OK(1, "支付成功等待出票"),
    TICKET_OK(2, "出票完成"),
    TICKET_LOCK(5, "出票中"),
    CANCEL_OK(12, "订单取消"),
    WAIT_CONFIRM(20, "等待座位确认"),
    APPLY_REFUNDMENT(30, "退款待确认"),
    WAIT_REFUNDMENT(31, "待退款"),
    REFUND_OK(39, "退款完成"),
    APPLY_CHANGE(40, "改签申请中"),
    CHANGE_OK(42, "改签完成"),
    APPLY_REFUND_PAY(50, "未出票申请退款"),
    ORDER_SUCCESS_WAIT_CONFIRM(51, "订座成功等待价格确认");


    OrderStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStatusEnum valueOf(int code) {
        switch (code) {
            case 0:
                return BOOK_OK;
            case 1:
                return PAY_OK;
            case 2:
                return TICKET_OK;
            case 5:
                return TICKET_LOCK;
            case 12:
                return CANCEL_OK;
            case 20:
                return WAIT_CONFIRM;
            case 30:
                return APPLY_REFUNDMENT;
            case 31:
                return WAIT_REFUNDMENT;
            case 39:
                return REFUND_OK;
            case 40:
                return APPLY_CHANGE;
            case 42:
                return CHANGE_OK;
            case 50:
                return APPLY_REFUND_PAY;
            case 51:
                return ORDER_SUCCESS_WAIT_CONFIRM;
        }
        return BOOK_OK;
    }

    public static OrderStatusEnum valueOfEnum(String desc) {
        switch (desc) {
            case "订座成功等待支付":
                return BOOK_OK;
            case "支付成功等待出票":
                return PAY_OK;
            case "出票完成":
                return TICKET_OK;
            case "出票中":
                return TICKET_LOCK;
            case "订单取消":
                return CANCEL_OK;
            case "等待座位确认":
                return WAIT_CONFIRM;
            case "退款待确认":
                return APPLY_REFUNDMENT;
            case "待退款":
                return WAIT_REFUNDMENT;
            case "退款完成":
                return REFUND_OK;
            case "改签申请中":
                return APPLY_CHANGE;
            case "改签完成":
                return CHANGE_OK;
            case "未出票申请退款":
                return APPLY_REFUND_PAY;
            case "订座成功等待价格确认":
                return ORDER_SUCCESS_WAIT_CONFIRM;
        }
        return BOOK_OK;
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
