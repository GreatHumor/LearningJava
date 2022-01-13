package com.gh.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author sso team
 * @description
 * @date 2021/9/13 3:15 上午
 */
@Slf4j
public class RedisConnectorTest {

    private static StatefulRedisConnection<String, String> CONNECTION;
    private static RedisClient CLIENT;
    private static ObjectMapper objectMapper;

    /**
     * 建立连接
     */
    @BeforeClass
    public static void beforeClass() {
        RedisURI redisUri = RedisURI.builder().withHost("localhost").withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS)).withDatabase(10).build();
        CLIENT = RedisClient.create(redisUri);
        CONNECTION = CLIENT.connect();
        objectMapper = new ObjectMapper();
    }

    /**
     * 关闭连接
     * @throws Exception
     */
    @AfterClass
    public static void afterClass() throws Exception {
        CONNECTION.close();
        CLIENT.shutdown();
    }

    public static RedisFuture<String> get(String key) {
        return CONNECTION.async().get(key);
    }

    public static RedisFuture<String> set(String key, String value) {
        return CONNECTION.async().set(key, value);
    }

    @Test
    public void write() throws Exception {
        for (int i = 0; i < 1000000; i++) {
            set(String.valueOf(i), String.valueOf(i));
            RedisFuture<String> result = get(String.valueOf(i));
            String s = result.get();
            if (StringUtils.isEmpty(s)) {
                throw new Exception("未读取到数据！");
            }
            System.out.println("i:" + i);
        }

    }



}
