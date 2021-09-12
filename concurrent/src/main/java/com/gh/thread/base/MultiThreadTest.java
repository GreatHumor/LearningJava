package com.gh.thread.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author sso team
 * @description
 * @date 2021/9/13 2:38 上午
 */
@Slf4j
public class MultiThreadTest {

    /**
     * Java 程序天生就是多线程程序，可以通过 JMX 来看一下一个普通的 Java 程序有哪些线程
     */
    @Test
    public void testFindThread() {
        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            log.info("线程信息 [{}] : {} ", threadInfo.getThreadId(), threadInfo.getThreadName());
        }

    }
}
