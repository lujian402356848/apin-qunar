package com.apin.qunar.app.basic.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String loginName;
    private String password;
    private String ip;
}
