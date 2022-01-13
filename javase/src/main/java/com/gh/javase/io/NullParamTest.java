package com.gh.javase.io;

import org.junit.Test;

/**
 * @author sso team
 * @description
 * @date 2021/11/11 8:41 下午
 */
public class NullParamTest {

    @Test
    public void nullParamDeliverTest() {

        User user = new User();
        decorate(user);
        System.out.println(user);
    }

    private void decorate(User user) {

        user = new User("luozh", 8);
        user.setAge(16);
        System.out.println(user);

    }

}
