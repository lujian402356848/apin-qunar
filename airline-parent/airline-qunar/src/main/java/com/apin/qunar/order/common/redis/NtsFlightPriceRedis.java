package com.apin.qunar.order.common.redis;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.utils.ProtobufUtil;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceParam;
import com.apin.qunar.order.domain.international.searchPrice.NtsSearchPriceResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class NtsFlightPriceRedis {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Object> operations;
    private long FLIGHT_INFO_EXPIRES_TIME = 15;//分钟为单位

//    @PostConstruct
    public void init() {
        operations = redisTemplate.opsForHash();
    }

    private String getCacheKey(NtsSearchPriceParam param) {
        StringBuilder keyStr = new StringBuilder(20);
        keyStr.append(param.getDepCity());
        keyStr.append(param.getArrCity());
        keyStr.append(param.getDepDate());
        if (StringUtils.isNotBlank(param.getRetDate())) {
            keyStr.append(param.getRetDate());
        }
        if (param.getAdultNum() != null && param.getAdultNum() > 0) {
            keyStr.append(param.getAdultNum());
        }
        if (param.getChildNum() != null && param.getChildNum() > 0) {
            keyStr.append(param.getChildNum());
        }
        if (StringUtils.isNotBlank(param.getCabinLevel())) {
            keyStr.append(param.getCabinLevel());
        }
        return keyStr.toString();
    }

    public void setFlightPriceInfo(NtsSearchPriceParam flightParam, NtsSearchPriceResultVO priceResultVO) {
        if (flightParam == null || StringUtils.isBlank(flightParam.getFlightCode())) {
            return;
        }
        String key = getCacheKey(flightParam);
        if (StringUtils.isBlank(key)) {
            return;
        }
        try {
            byte[] values = ProtobufUtil.serialize(priceResultVO);
            operations.put(key, flightParam.getFlightCode(), values);
            redisTemplate.expire(key, FLIGHT_INFO_EXPIRES_TIME, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.error("设置国际航班价格缓存信息异常,param:{}", JSON.toJSONString(flightParam), e);
        }
    }

    public NtsSearchPriceResultVO getFlightPriceInfo(NtsSearchPriceParam flightParam) {
        NtsSearchPriceResultVO priceResultVO = null;
        String key = getCacheKey(flightParam);
        try {
            byte[] bytes = (byte[]) operations.get(key, flightParam.getFlightCode());
            if (bytes != null && bytes.length > 0) {
                priceResultVO = ProtobufUtil.deserialize(bytes, NtsSearchPriceResultVO.class);
            }
        } catch (Exception e) {
            operations.delete(key, flightParam.getFlightCode());//如果解析失败，则删除该缓存
            log.error("获取国际航班价格缓存信息异常", e);
        }
        return priceResultVO;
    }
}