package com.apin.qunar.basic.common.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Slf4j
@Configuration
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.timeOut}")
    private long timeOut;

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory());
        StringRedisSerializer redisSerializer = new StringRedisSerializer();

        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setEnableDefaultSerializer(false);
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(0);
        if (StringUtils.isNotBlank(password)) {
            redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        }
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeOut));
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration.build());
    }
}