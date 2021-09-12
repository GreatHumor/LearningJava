package com.gh.thread.threadLocal;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author sso team
 * @description 查看ThreadLocalMap中的弱引用
 * @date 2021/9/11 10:47 下午
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> test("abc", false));
        t1.start();
        t1.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("edf", true));
        t2.start();
        t2.join();
    }

    private static void test(String s, boolean isGc) {
        new ThreadLocal<>().set(s);
        if(isGc) {
            System.gc();
        }
        Thread t = Thread.currentThread();
        Class<? extends Thread> clazz = t.getClass();
        try {
            Field field = clazz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> threadLocalMapClass = threadLocalMap.getClass();
            Field tableField = threadLocalMapClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr =(Object[])tableField.get(threadLocalMap);

            for (Object o : arr) {
                if(Objects.nonNull(o)) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.printf("弱引用key : %s, 值：%s\n", referenceField.get(o), valueField.get(o));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
