package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.service.impl.ResponseResult;
import com.apin.qunar.common.utils.JacksonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @outhor lujian
 * @create 2018-06-21 22:47
 */
@Slf4j
public abstract class NtsApiService<Req, Res> {
    @Autowired
    private NtsRequestServiceImpl requestService;

    protected abstract String getTag();

    protected abstract TypeReference<Res> getTypeReference();

    public Res execute(Req request) {
        try {
            String requestJson = JacksonUtil.encode(request);
            String response = requestService.doRequest(getTag(), requestJson);
            return JacksonUtil.decode(response, getTypeReference());
        } catch (Exception e) {
            log.error("tag:{} get api response error", getTag(), e);
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
            log.error("tag:{} get api response error", getTag(), e);
        }
        return null;
    }
}