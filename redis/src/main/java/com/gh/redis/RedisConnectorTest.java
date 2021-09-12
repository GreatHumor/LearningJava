package com.gh.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author sso team
 * @description
 * @date 2021/9/13 3:15 上午
 */
@Slf4j
public class RedisConnectorTest {

    private static StatefulRedisConnection<String, String> CONNECTION;
    private static RedisClient CLIENT;

    @BeforeClass
    public static void beforeClass() {
        RedisURI redisUri = RedisURI.builder().withHost("localhost").withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS)).withDatabase(10).build();
        CLIENT = RedisClient.create(redisUri);
        CONNECTION = CLIENT.connect();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        CONNECTION.close();
        CLIENT.shutdown();
    }


}
