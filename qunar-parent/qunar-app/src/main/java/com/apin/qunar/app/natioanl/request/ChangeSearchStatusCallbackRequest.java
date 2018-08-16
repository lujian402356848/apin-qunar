package com.apin.qunar.app.natioanl.request;


import lombok.Data;

/**
 * @outhor ligang
 * @create 2018-08-05 21:31
 */
@Data
public class ChangeSearchStatusCallbackRequest {
    private String tag;
    private String createTime;
    private String sign;
    private String data;
}
