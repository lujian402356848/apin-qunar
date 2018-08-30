package com.apin.qunar.basic.common.constant;

/**
 * @outhor lujian
 * @create 2018-07-30 14:54
 */
public class SmsConstants {
    public static final String TICKET_NO = "【爱拼机】订单『%s』已出票：%s。请至少提前120分钟到机场办理值机。重要提示：航空公司不会以机械故障、航班取消等原因要求您进行付款或转账，谨防欺诈!";
    public static final String TICKET_NO_BACK = "【爱拼机】订单『【去】%s,【返】%s』已出票：%s。请至少提前120分钟到机场办理值机。重要提示：航空公司不会以机械故障、航班取消等原因要求您进行付款或转账，谨防欺诈!";
    public static final String FLIGHT_CHANGE = "【航班变动通知】很抱歉的通知您，%s已变更为%s，预计起降时间为%s，请按新航班起飞时间，提前120分钟到机场办理值机。【爱拼机】";
    public static final String FLIGHT_CANCEL = "【航班取消通知】很抱歉的通知您，您【%s】预定的%s %s从%s到%s的%s航班因天气等原因取消。如有问题请拨打爱拼机官方客服电话0571—58122998。【爱拼机】";
    public static final String FLIGHT_RECOVERY = "【航班取消后恢复通知】尊敬的旅客您好！您【%s】预定的%s %s从%s到%s的%s航班取消后现已恢复，请按原计划起飞时间，提前120分钟到机场办理值机。如有问题请拨打爱拼机官方客服电话0571—58122998。【爱拼机】";
    public static final String FLIGHT_CANCEL_PROTECT = "【航班取消有保护通知】很抱歉的通知您，您预定的%s因航空公司等原因取消，现保护到%s，预计起降时间为%s，请按新航班起飞时间，提前120分钟到机场办理值机。如有问题请拨打爱拼机官方客服电话0571—58122998。【爱拼机】";

    public static final String MERCHANT_REGISTER = "【爱拼机】尊敬的【%s】感谢您注册杭州爱拼机机票服务平台，您的资料已提交成功，我司正在审核中，会在7个工作日内通知您审核结果，请耐心等待。如有问题请拨打爱拼机官方客服电话0571—58122998。";
    public static final String MERCHANT_AUDIT_PASS = "【爱拼机】您的注册资料审核已经通过，初始密码为111，请登录爱拼机机票服务平台 网址链接 查询预订机票。如有问题请拨打爱拼机官方客服电话0571—58122998。";
    public static final String MERCHANT_AUDIT_NO_PASS = "【爱拼机】您的注册资料未审核通过。如有问题请拨打爱拼机官方客服电话0571—58122998。";

    public static final String RETURN = "【爱拼机】您【%s】预定的%s %s从%s到%s的订单【%s】已原路退款，预计1-7个工作日到账。";
    public static final String QUNAR_PAY_SUCCESS = "【爱拼机】您预定的%s %s从%s到%s的订单【%s】已支付成功，正等待出票。如有问题请拨打爱拼机官方客服电话0571—58122998。";
    public static final String QUNAR_PAY_FAIL_ALI = "【爱拼机】订单【%s】支付宝支付成功，但去哪儿支付失败,原因:%s";
    public static final String QUNAR_CHANGE = "【爱拼机】您【%s】预定的%s %s从%s到%s的订单【%s】已改签成功，%s，如有问题请拨打爱拼机官方客服电话0571—58122998。";
    public static final String QUNAR_PAY_FAIL_WECHAT = "【爱拼机】订单【%s】微信支付成功，但去哪儿支付失败,原因:%s";
    public static final String MERCHANT_VERIFY_CODE = "【爱拼机】验证码:【%s】，1分钟内输入有效，请立即注册";
    public static final String USER_LOGIN_VERIFY_CODE = "【爱拼机】验证码:【%s】，1分钟内输入有效，请立即登录";
    public static final String USER_CHANGE_PASSWORD_VERIFY_CODE = "【爱拼机】验证码:【%s】，1分钟内输入有效，请立即修改密码";
}