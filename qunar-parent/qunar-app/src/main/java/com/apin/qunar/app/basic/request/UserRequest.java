package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRequest extends BaseRequest {
    private String realName;
    private String account;
    private String password;
    private String mobileNo;
    private String verifyCode;
    private int hasLogin;//1:登录，2:修改密码
}