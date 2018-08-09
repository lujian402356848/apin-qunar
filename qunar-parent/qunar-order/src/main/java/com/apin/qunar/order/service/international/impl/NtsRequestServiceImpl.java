package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.service.impl.BaseRequestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @outhor lujian
 * @create 2018-06-21 22:51
 */
@Service
public class NtsRequestServiceImpl extends BaseRequestService {
    @Value("${qunar.international.key}")
    private String key;
    @Value("${qunar.international.token}")
    private String token;

    public String doRequest(String tag, String params) {
        return super.doRequest(this.key, this.token, tag, params);
    }
}
