package com.apin.qunar.order.common.redis;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.common.utils.ProtobufUtil;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightParam;
import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class NtsFlightRedis {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private ValueOperations<String, Object> operations;
    private long FLIGHT_INFO_EXPIRES_TIME = 30;//秒为单位

    @PostConstruct
    public void init() {
        operations = redisTemplate.opsForValue();
    }

    private String getCacheKey(NtsSearchFlightParam param) {
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

    public void setFlightInfo(NtsSearchFlightParam flightParam, List<NtsSearchFlightResultVO> flightResult) {
        if (flightParam == null) {
            return;
        }
        String key = getCacheKey(flightParam);
        if (StringUtils.isBlank(key)) {
            return;
        }
        FlightCacheEntry flightCacheEntry = new FlightCacheEntry(flightResult);
        try {
            byte[] values = ProtobufUtil.serialize(flightCacheEntry);
            operations.set(key, values);
            redisTemplate.expire(key, FLIGHT_INFO_EXPIRES_TIME, TimeUnit.SECONDS);
        } catch (RedisConnectionFailureException e) {
            log.error("redis连接失败", e);
        } catch (Exception e) {
            log.error("设置国际航班缓存信息异常,param:{}", JSON.toJSONString(flightParam), e);
        }
    }

    public List<NtsSearchFlightResultVO> getFlightInfo(NtsSearchFlightParam flightParam) {
        FlightCacheEntry flightCacheEntry = null;
        String key = getCacheKey(flightParam);
        try {
            byte[] bytes = (byte[]) operations.get(key);
            if (bytes != null && bytes.length > 0) {
                flightCacheEntry = ProtobufUtil.deserialize(bytes, FlightCacheEntry.class);
            }
        } catch (RedisConnectionFailureException e) {
            log.error("redis连接失败", e);
        } catch (Exception e) {
            operations.set(key, "", 1, TimeUnit.SECONDS);//如果解析失败，则删除该缓存
            log.error("获取国际航班缓存信息异常", e);
        }
        return flightCacheEntry == null ? null : flightCacheEntry.getFligths();
    }
}