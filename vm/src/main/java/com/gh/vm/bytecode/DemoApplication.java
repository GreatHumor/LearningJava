package com.gh.vm.bytecode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sso team
 * @description
 * @date 2022/2/18 10:10 上午
 */
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            testExceptionTruncate();
        }
    }

    private static void testExceptionTruncate() {

        try {
            // 人工构造异常抛出的场景
            ((Object)null).getClass();
        } catch (Exception e) {
            if (e.getStackTrace().length == 0) {
                System.out.println("stack miss;");
            }
            try {
                // 堆栈消失的时候当前线程休眠5秒，便于观察
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                // do nothing
            }
        }
        System.out.println("stack still exist;");
    }

}
