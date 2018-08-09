package com.apin.qunar.order.service.common.impl;


import com.apin.qunar.order.domain.common.ApiResult;
import com.apin.qunar.order.domain.common.sign.SignParam;
import com.apin.qunar.order.domain.common.sign.SignResultVO;
import com.apin.qunar.order.service.common.SignService;
import com.apin.qunar.order.service.national.impl.ApiService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * @outhor lujian
 * @create 2018-06-23 18:04
 */
@Service
@Slf4j
public class SignServiceImpl extends ApiService<SignParam, ApiResult<SignResultVO>> implements SignService {

    @Override
    protected String getTag() {
        return "flight.national.supply.sl.sign";
    }

    @Override
    protected TypeReference<ApiResult<SignResultVO>> getTypeReference() {
        return new TypeReference<ApiResult<SignResultVO>>() {
        };
    }

    @Override
    public String sign(SignParam signParam) {
        final Base64.Decoder decoder = Base64.getDecoder();
        ApiResult<SignResultVO> apiResult = execute(signParam);
        if (apiResult == null) {
            return "签约失败";
        }
        if(!"ACCEPT".equals(apiResult.getResult().getSignStatus()))
        {
            return "该账户已签约";
        }
        String signHtml = null;
        try{
            signHtml = new String(decoder.decode(apiResult.getResult().getRetHtml()), apiResult.getResult().getCharSet());
        }catch (Exception e)
        {
            log.error("网关响应报文解码失败,retHtml:{}", apiResult.getResult().getRetHtml());
        }
        return signHtml;

//        return new ApiResult<>(apiResult, BeanUtil.copyProperties(apiResult.getResult(), SearchSignResultVO.class));
    }
}