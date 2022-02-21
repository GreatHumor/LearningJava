package com.main;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author sso team
 * @description
 * @date 2022/2/18 11:39 上午
 */
public class RedefineSuccess {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(getPid());
        while (true){
            TimeUnit.SECONDS.sleep(5);
            hello();
        }
    }

    public static void hello(){
        System.out.println("agent");
    }

    /**
     * 获取当前运行 JVM PID
     * @return
     */
    private static String getPid() {
        // get name representing the running Java virtual machine.
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        return name.split("@")[0];
    }


}
