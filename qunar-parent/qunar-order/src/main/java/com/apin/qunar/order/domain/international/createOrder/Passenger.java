package com.apin.qunar.order.domain.international.createOrder;

import lombok.Data;

/**
 * Created by wangliang.wang on 2017/10/28.
 */
@Data
public class Passenger {

    private String name;
    //乘客类型，0：成人，1：儿童
    private Integer ageType;
    //出生日期
    private String birthday;
    //性别,M:男,F:女
    private String gender;
    //证件号码
    private String cardNum;
    //证件类型,PP - 护照,GA - 港澳通行证,TW - 台湾通行证,TB - 台胞证,HX -回乡证,HY - 国际海员证
    private String cardType;
    //证件发行，国家二字码
    private String cardIssuePlace;
    //证件有效时间
    private String cardExpired;
    //乘客国籍，国家二字码
    private String nationality;
    //电话
    private String mobile;
    //电话国家码
    private String mobCountryCode;
}
