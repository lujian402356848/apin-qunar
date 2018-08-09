package com.apin.qunar.order.common.redis;

import com.apin.qunar.common.utils.ProtobufUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class NtsFlightRedis {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    //   @Resource(name="redisTemplate")
    private SetOperations<String, Object> operations;
    private long FLIGHT_INFO_EXPIRES_TIME = 15;//分钟为单位

    @PostConstruct
    public void init() {
        operations = redisTemplate.opsForSet();
    }

    public void setFlightInfo(String key, Object obj) {
        if (StringUtils.isBlank(key) || obj == null) {
            return;
        }
        byte[] values = ProtobufUtil.serialize(obj);
        operations.add(key, values);
        redisTemplate.expire(key, FLIGHT_INFO_EXPIRES_TIME, TimeUnit.MINUTES);
    }

    public Object getFlightInfo(String key, Class clazz) {
        byte[] bytes = (byte[]) redisTemplate.boundValueOps(key).get();
        return ProtobufUtil.deserialize(bytes, clazz);
    }
}