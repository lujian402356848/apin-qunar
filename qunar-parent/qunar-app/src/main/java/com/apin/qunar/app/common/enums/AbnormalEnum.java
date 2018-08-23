package com.apin.qunar.app.common.enums;

import lombok.Getter;

/**
 * @author fy
 * @version 1.0
 * @date 2018/8/8 16:39
 */
@Getter
public enum AbnormalEnum {

    /**
     * 全局异常捕获输出.
     */
    PARAMETER_IS_INCORRECT(1000, "参数校验失败,请核实参数"),

    TIME_NOT_EMPTY(1001, "timestamp不能为空"),

    REQUEST_TIMEOUT(1002, "该请求超过10秒，做无效处理"),

    MERCHANT_NUMBER_NOT_EMPTY(1003, "商户号不能为空"),

    SIGNATURE_NOT_EMPTY(1004, "签名不能为空"),

    INCORRECT_SIGNATURE(1005, "签名不正确"),

    UNLAWFUL_REQUEST(1006,"非法请求");

    private Integer code;
    private String message;

    AbnormalEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
