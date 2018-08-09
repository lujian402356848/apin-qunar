package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.service.impl.BaseRequestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @outhor lujian
 * @create 2018-06-21 22:50
 */
@Service
public class RequestServiceImpl extends BaseRequestService {
    @Value("${qunar.natioanl.key}")
    private String key;
    @Value("${qunar.natioanl.token}")
    private String token;

    public String doRequest(String tag, String params) {
        return super.doRequest(this.key, this.token, tag, params);
    }

    public Map<String, String> buildParamMap(String tag, String params) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return super.buildParamMap(this.key, this.token, tag, params);
    }
}