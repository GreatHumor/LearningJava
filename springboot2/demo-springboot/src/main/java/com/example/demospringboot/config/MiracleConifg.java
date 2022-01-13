package com.example.demospringboot.config;

import com.example.demospringboot.dao.UserMapper;
import com.example.demospringboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sso team
 * @description
 * @date 2022/1/11 4:27 下午
 */
@Configuration
public class MiracleConifg {

    @Autowired
    private UserMapper userMapper;


    @Bean
    public User user() {
        User user = new User();
        user.setName("zhangsan");
        userMapper.insert(user);
        return user;
    }

}
