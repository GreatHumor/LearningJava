package com.gh.thread.threadLocal;

import org.junit.Test;

/**
 * @author sso team
 * @description
 * 我们使用ThreadLocal的时候，在异步场景下是无法给子线程共享父线程中创建的线程副本数据的。
 * 为了解决这个问题，JDK 中还有一个InheritableThreadLocal类
 *
 * 但InheritableThreadLocal仍然有缺陷，一般我们做异步化处理都是使用的线程池，
 * 而InheritableThreadLocal是在new Thread中的init()方法给赋值的，而线程池是线程复用的逻辑，所以这里会存在问题。
 * 阿里巴巴开源了一个TransmittableThreadLocal组件可以解决这个问题
 * @date 2021/9/13 2:23 上午
 */
public class InheritableThreadLocalTest {


    @Test
    public void testInheritableThreadLocal() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        threadLocal.set("父类数据:threadLocal");
        inheritableThreadLocal.set("父类数据:inheritableThreadLocal");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程获取父类ThreadLocal数据：" + threadLocal.get());
                System.out.println("子线程获取父类inheritableThreadLocal数据：" + inheritableThreadLocal.get());
            }
        }).start();
    }

}
