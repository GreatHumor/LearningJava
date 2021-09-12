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

    /**
     * threadLocalMap的hash算法所用的到递增值，每当创建一个ThreadLocal对象，
     * 这个ThreadLocal.nextHashCode 这个值就会增长 0x61c88647
     * 这个值很特殊，它是斐波那契数 也叫 黄金分割数。hash增量为 这个数字，带来的好处就是 hash 分布非常均匀。
     */
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

    /**
     * threadLocal的基本使用
     */
    @Test
    public void testThreadLocalGet() {
        ThreadLocalTest.add("今夜明珠色");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }

    /**
     * 使用该数用于hash算法，能够让产生的哈希码分布得十分均匀
     */
    @Test
    public void testHashIncr() {
        int hashCode;
        for (int i = 0; i < 16; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int bucket = hashCode & 15;
            System.out.println(i + "在桶中的位置" + bucket);
        }
    }



}
