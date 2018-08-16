package com.apin.qunar.app.common.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @outhor lujian
 * @create 2018-07-17 9:58
 */
@Data
public abstract class BaseRequest {
    @NotEmpty(message = "merchantNo不能为空")
    private String merchantNo;
    private long timestamp;
    private String sign;
}
