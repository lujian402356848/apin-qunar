package com.apin.qunar.basic.service.impl;

import com.apin.qunar.basic.common.constant.Constants;
import com.apin.qunar.common.utils.HttpClientUtil;
import com.apin.qunar.common.utils.Md5Util;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wjjunjjun.wang on 2017/7/25.
 */
@Slf4j
@Service
public class BaseRequestService {

    private Joiner.MapJoiner mapJoiner = Joiner.on("&").withKeyValueSeparator("=");

    protected String doRequest(String key, String token, String tag, String params) {
        String result = null;
        try {
            Map<String, String> paramsMap = buildParamMap(key, token, tag, params);
            String url = buildRequestUrl(paramsMap);
            result = HttpClientUtil.doGet(url);
        } catch (Exception e) {
            log.error("request error", e);
        }
        return result;
    }

    protected Map<String, String> buildParamMap(final String key, final String token, final String tag, String params) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, String> paramMap = Maps.newHashMap();
        String createTime = String.valueOf(new Date().getTime());
        String sign = getSign(key, token, tag, params, createTime);
        paramMap.put("sign", sign);
        paramMap.put("createTime", createTime);
        paramMap.put("token", token);
        paramMap.put("tag", tag);
        paramMap.put("params", URLEncoder.encode(params, "utf-8"));
        return paramMap;
    }

    private String buildRequestUrl(final Map<String, String> paramsMap) {
        return Constants.BASE_URL + mapJoiner.join(paramsMap);
    }

    private String getSign(final String key, final String token, final String tag, String params, final String createTime) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        List<String> requestParams = Lists.newArrayList("tag=" + tag, "params=" + params, "key=" + key, "token=" + token, "createTime=" + createTime);
        Collections.sort(requestParams);
        String beforeMd5Str = linkStr(requestParams);
        return Md5Util.encrypt(beforeMd5Str);
    }

    private String linkStr(final List<String> requestParams) {
        StringBuilder sb = new StringBuilder();
        for (String param : requestParams) {
            sb.append(param);
        }
        return sb.toString();
    }

}
