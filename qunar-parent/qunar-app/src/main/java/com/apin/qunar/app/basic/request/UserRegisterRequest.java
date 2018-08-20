package com.apin.qunar.app.basic.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRegisterRequest extends BaseRequest {
    private String realName;
    private String account;
    private String password;
    private String mobileNo;
    private String ip;
}
