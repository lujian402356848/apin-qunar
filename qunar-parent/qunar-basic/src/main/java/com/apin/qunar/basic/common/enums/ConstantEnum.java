package com.apin.qunar.basic.common.enums;


import lombok.Getter;

/**
 * @author fy
 * @version 1.0
 * @date 2018/8/8 16:39
 */
@Getter
public enum ConstantEnum {

    /**
     * 全局常量枚举.
     */
    TEST_SIGN(2000, "apin1818lujian");


    private Integer code;
    private String message;

    ConstantEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
