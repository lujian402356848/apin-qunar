package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.service.impl.ResponseResult;
import com.apin.qunar.common.utils.JacksonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @outhor lujian
 * @create 2018-06-21 22:45
 */
public abstract class ApiService<Req, Res> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiService.class);
    @Autowired
    private RequestServiceImpl requestService;

    protected abstract String getTag();

    protected abstract TypeReference<Res> getTypeReference();

    public Res execute(Req request) {
        try {
            Preconditions.checkNotNull(request);
            String requestJson = JacksonUtil.encode(request);
            String response = requestService.doRequest(getTag(), requestJson);
            Preconditions.checkNotNull(response);
            return JacksonUtil.decode(response, getTypeReference());
        } catch (Exception e) {
            LOGGER.error("tag:{} get api response error", getTag(), e);
        }
        return null;
    }

    public Res execute(Req request, ResponseResult responseResult) {
        try {
            Preconditions.checkNotNull(request);
            String requestJson = JacksonUtil.encode(request);
            responseResult = requestService.doRequestResult(getTag(), requestJson);
            Preconditions.checkNotNull(responseResult.getResult());
            return JacksonUtil.decode(responseResult.getResult(), getTypeReference());
        } catch (Exception e) {
            LOGGER.error("tag:{} get api response error", getTag(), e);
        }
        return null;
    }
}
