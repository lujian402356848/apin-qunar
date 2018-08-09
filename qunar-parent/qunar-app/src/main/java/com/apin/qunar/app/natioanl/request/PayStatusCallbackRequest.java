package com.apin.qunar.app.natioanl.request;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-06-27 21:45
 */
@Data
public class PayStatusCallbackRequest {
    private String tag;
    private String createTime;
    private String sign;
    private String data;
}
