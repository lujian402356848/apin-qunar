package com.apin.qunar.order.common.enums;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
public enum DistributionTypeEnum {

    EXPRESS(1, "快递");

    DistributionTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static DistributionTypeEnum valueOfEnum(String desc) {
        switch (desc) {
            case "快递":
                return EXPRESS;
        }
        return EXPRESS;
    }

    public final int code;
    public final String desc;
}
