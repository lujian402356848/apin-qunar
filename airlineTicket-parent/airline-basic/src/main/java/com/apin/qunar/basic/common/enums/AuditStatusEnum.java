package com.apin.qunar.basic.common.enums;

/**
 * @outhor lujian
 * @create 2018-07-23 14:43
 */
public enum AuditStatusEnum {
    AWAITAUDIT(0, "待审核"),
    Pass(1, "审核通过"),
    NoPass(2, "审核不通过");

    AuditStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    public static AuditStatusEnum valueOf(int code) {
        AuditStatusEnum auditStatusEnum = AuditStatusEnum.AWAITAUDIT;
        switch (code) {
            case 0:
                auditStatusEnum = AuditStatusEnum.AWAITAUDIT;
                break;
            case 1:
                auditStatusEnum = AuditStatusEnum.Pass;
                break;
            case 2:
                auditStatusEnum = AuditStatusEnum.NoPass;
                break;
        }
        return auditStatusEnum;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
