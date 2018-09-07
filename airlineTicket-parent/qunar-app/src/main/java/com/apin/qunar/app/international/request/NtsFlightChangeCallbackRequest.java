package com.apin.qunar.app.international.request;

import lombok.Data;

/**
 * @outhor lujian
 * @create 2018-07-26 22:22
 */
@Data
public class NtsFlightChangeCallbackRequest {
    private String tag;
    private String createTime;
    private String sign;
    private String data;
}
