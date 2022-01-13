package com.example.demoredisson.config;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author sso team
 * @description
 * @date 2021/12/5 10:18 上午
 */
public class LRedisTemplate extends RedisTemplate<String, Object> {

    public LRedisTemplate(final RedisConnectionFactory connectionFactory) {
        this();
        setConnectionFactory(connectionFactory);
        afterPropertiesSet();
    }

    public LRedisTemplate() {

    }
}
