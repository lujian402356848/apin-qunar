package com.apin.qunar.basic.common.enums;

/**
 * @outhor lujian
 * @create 2018-07-25 15:47
 */
public enum AccountTypeEnum {
    EMPLOYEE(1, "员工账户"),
    MERCHANT(2, "商户账户");

    AccountTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    public static AccountTypeEnum valueOf(int code) {
        AccountTypeEnum accountTypeEnum = AccountTypeEnum.EMPLOYEE;
        switch (code) {
            case 1:
                accountTypeEnum = AccountTypeEnum.EMPLOYEE;
                break;
            case 2:
                accountTypeEnum = AccountTypeEnum.MERCHANT;
                break;
        }
        return accountTypeEnum;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
