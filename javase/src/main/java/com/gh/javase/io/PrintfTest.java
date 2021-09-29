package com.gh.javase.io;

import org.junit.Test;
import org.junit.runner.notification.RunListener;

/**
 * @author sso team
 * @description 格式化输出demo
 * @date 2021/9/20 3:39 下午
 */
public class PrintfTest {


    @Test
    public void testPrintf() {
        int i = 18;
        float f = 18.9989f;
        String s = "to be, or not to be";

        System.out.printf("integer format: %d\n", i);
        System.out.printf("float format: %.2f\n", f);
        System.out.printf("float format: %.3f\n", f);
        System.out.printf("string format: %s\n", s);

    }

}
