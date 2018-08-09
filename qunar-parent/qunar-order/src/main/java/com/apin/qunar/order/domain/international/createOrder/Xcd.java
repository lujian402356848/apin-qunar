package com.apin.qunar.order.domain.international.createOrder;

import lombok.Data;

/**
 * Created by wangliang.wang on 2017/10/28.
 */
@Data
public class Xcd {
    //是否索要行程单，0：不索要，1：索要,行程单索要时下面的参数必须填写，在qae-api中校验
    private Integer reimburseType;
    //收件人姓名
    private String name;
    //收件人电话
    private String mobile;
    //收件地址-省
    private String province;
    //收件地址-市
    private String city;
    //收件地址-区
    private String district;
    //详细地址
    private String addressReminder;
    //发票抬头类型0单位、1个人
    private Integer receiptTitleType;
    //发票抬头
    private String receiptTitle;
    //纳税人识别号
    private String taxpayerId;
}
