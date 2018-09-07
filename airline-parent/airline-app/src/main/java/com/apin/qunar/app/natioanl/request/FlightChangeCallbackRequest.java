package com.apin.qunar.app.natioanl.request;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-26 15:23
 */
@Data
public class FlightChangeCallbackRequest {
    private String tag;
    private String createTime;
    private String sign;
    private String data;
}