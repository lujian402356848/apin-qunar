package com.apin.qunar.app.common.domain;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-23 19:28
 */
@Data
public class CommonRequest {
    private String merchantNo;
    private String data;
    private String sign;
    private long timestamp;
}
