package com.apin.qunar.order.common.enums;

/**
 * @outhor lujian
 * @create 2018-07-09 16:34
 * 国际订单状态
 */
public enum NtsOrderStatusEnum {
    INIT(0, "初始状态"),
    BOOK_OK(2, "订座成功等待支付"),
    PAY_OK(4, "支付成功等待出票"),
    TICKET_OK(5, "出票完成"),
    TICKET_FAIL(6, "出票失败"),
    CANCEL_OK(7, "订单取消");

    NtsOrderStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    public static String valueOfDesc(Integer value) {
        switch (value) {
            case 0:
                return INIT.getDesc();
            case 2:
                return BOOK_OK.getDesc();
            case 4:
                return PAY_OK.getDesc();
            case 5:
                return TICKET_OK.getDesc();
            case 6:
                return TICKET_FAIL.getDesc();
            case 7:
                return CANCEL_OK.getDesc();
            default:
                return "未知";
        }
    }

    public static NtsOrderStatusEnum valueOf(Integer value) {
        switch (value) {
            case 0:
                return INIT;
            case 2:
                return BOOK_OK;
            case 4:
                return PAY_OK;
            case 5:
                return TICKET_OK;
            case 6:
                return TICKET_FAIL;
            case 7:
                return CANCEL_OK;
        }
        return INIT;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
