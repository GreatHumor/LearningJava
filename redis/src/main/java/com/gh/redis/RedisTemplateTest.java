package com.gh.redis;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gh.redis.serialize.LoginContext;
import com.gh.redis.serialize.ParaAuthentication;
import com.gh.redis.serialize.ParaCredential;
import com.gh.redis.serialize.UserEntity;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sso team
 * @description
 * @date 2021/10/27 1:44 下午
 */
@Slf4j
public class RedisTemplateTest {

    private static RedisTemplate<String, Object> redisTemplate;


    /**
     * 建立连接
     */
    @BeforeClass
    public static void beforeClass() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(6379);
        configuration.setHostName("127.0.0.1");
        configuration.setDatabase(10);
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(configuration);
        lettuceConnectionFactory.afterPropertiesSet();

        redisTemplate = new RedisTemplate<>();

        final RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // objectMapper.setVisibility(PropertyAccessor.ALL,
        // JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.EVERYTHING, JsonTypeInfo.As.PROPERTY);

        final GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);

        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);

        redisTemplate.afterPropertiesSet();
    }



    @Test
    public void putVal() {
        Teacher t1 = new Teacher("1", 18);
        Teacher t2 = new Teacher("2", 19);
        UserDomain user = new UserDomain("jennie", 18, Arrays.asList(t1, t2));
        put("k1", user);
        Object k1 = get("k1");
        System.out.println(k1);
    }

    @Test
    public void JacksonType() {
        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo zoo = new Zoo(dog);
        put("zoo", zoo);
        Zoo zoo1 = (Zoo)get("zoo");
        System.out.println(zoo1);
    }

    @Test
    public void loginContext() {
        UserEntity user = new UserEntity("test");
        ParaAuthentication paraAuthentication = new ParaAuthentication("user");
        ParaCredential paraCredential = new ParaCredential("at-123456");

        LoginContext context = new LoginContext(Arrays.asList(paraCredential), Arrays.asList(paraAuthentication),
                user);

        put("lt", context);
        LoginContext lt =(LoginContext) get("lt");
        Object lt1 = get("lt");
        System.out.println(lt);
    }











    public static boolean put(final String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            log.error("Exception:{}", e);
        }
        return result;
    }

    public static  <T> T get(String key) {
        T obj = (T) redisTemplate.opsForValue().get(key);
        if (obj == null) {
            return null;
        }
        return obj;
    }
















}
