package com.example.demoredisson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author sso team
 * @description
 * @date 2021/12/5 10:19 上午
 */
@Configuration
public class RedisConfiguration {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public LRedisTemplate redisTemplate() {
        return new LRedisTemplate(redisConnectionFactory);
    }

}
