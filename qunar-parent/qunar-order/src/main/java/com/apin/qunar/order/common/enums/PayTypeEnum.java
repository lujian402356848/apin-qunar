package com.apin.qunar.order.common.enums;

public enum PayTypeEnum {
    ALIPAY(1, "支付宝"),
    WECHATPAY(2, "微信");

    private int code;
    private String desc;

    PayTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PayTypeEnum valueOf(Integer type) {
        PayTypeEnum payTypeEnum = PayTypeEnum.ALIPAY;
        switch (type) {
            case 1:
                payTypeEnum = PayTypeEnum.ALIPAY;
                break;
            case 2:
                payTypeEnum = PayTypeEnum.WECHATPAY;
        }
        return payTypeEnum;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
