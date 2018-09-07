package com.apin.qunar.basic.common.enums;

/**
 * @outhor lujian
 * @create 2018-07-30 9:43
 */
public enum SmsSendTypeEnum {
    NO_PAY(1, "未支付"),
    TICKET(2, "出票"),
    TICKET_NO(3, "生成票号"),
    RETURN(4, "退票"),
    FLIGHT_CHANGE(5, "航变"),
    FLIGHT_CANCEL(6, "航班取消"),
    FLIGHT_RECOVERY(7, "航班取消后恢复"),
    FLIGHT_CANCEL_PROTECT(8, "航班取消有保护"),
    CHANGE(9, "改签成功"),
    PAY_SUCCESS(10, "支付成功"),
    MERCHANT_REGISTER(11, "商户注册"),
    MERCHANT_VERIFY_CODE(12, "商户注册验证码"),
    MERCHANT_AUDIT_PASS(13, "商户审核通过"),
    MERCHANT_AUDIT_NO_PASS(14, "商户审核不通过"),
    QUNAER_PAY_FAIL_NOTIFY(21, "去哪儿支付失败"),
    WECHAT_PAY_FAIL_NOTIFY(22, "微信支付失败"),
    WECHAT_REFUND_FAIL_NOTIFY(22, "微信退款失败"),
    ALIPAY_PAY_FAIL_NOTIFY(23, "支付宝支付失败"),
    ALIPAY_REFUND_FAIL_NOTIFY(24, "支付宝退款失败"),
    USER_LOGIN_VERIFY_CODE(32, "用户登录的验证码"),
    USER_CHANGE_PASSWORD_VERIFY_CODE(33, "用户修改密码的验证码"),
    MERCHANT_ACTIVITY(40, "商户活动");

    SmsSendTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
