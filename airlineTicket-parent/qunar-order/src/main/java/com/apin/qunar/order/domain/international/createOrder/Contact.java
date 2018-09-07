package com.apin.qunar.order.domain.international.createOrder;

import lombok.Data;

/**
 * Created by wangliang.wang on 2017/10/28.
 */
@Data
public class Contact {
    //姓名
    private String name;
    //邮箱
    private String email;
    //联系人电话
    private String mobile;
    //联系人电话国家码
    private Integer mobCountryCode;
}
