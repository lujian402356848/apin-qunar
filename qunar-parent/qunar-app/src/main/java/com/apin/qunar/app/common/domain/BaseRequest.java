package com.apin.qunar.app.common.domain;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-17 9:58
 */
@Data
public abstract class BaseRequest {
    private String merchantNo;
    private long timestamp;
    private String sign;
}
