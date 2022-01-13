package com.example.demoredisson.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sso team
 * @description
 * @date 2021/12/4 7:33 下午
 */
@RestController
public class RedissonController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/rand")
    public void put() {

        redisTemplate.opsForValue().set(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

}
