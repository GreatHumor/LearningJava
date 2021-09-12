package com.gh.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sso team
 * @description
 * @date 2021/9/12 7:19 下午
 */
public class ThreadLocalTest {

    private List<String> messages = new ArrayList<>();

    private static final int HASH_INCREMENT = 0x61c88647;

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();
        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    @Test
    public void testThreadLocalGet() {
        ThreadLocalTest.add("今夜明珠色");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }



}
