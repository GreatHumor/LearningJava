package com.main;

import com.sun.tools.attach.VirtualMachine;

import java.io.File;

/**
 * @author sso team
 * @description
 * @date 2022/2/18 11:35 上午
 */
public class JvmAttachMain {

    public static void main(String[] args) {
        String pid = "1933";
        String classPath = "/Users/luozihan/learning/LearningJava/vm/target/classes/com/main/RedefineSuccess.class";

        // 获取 Agent jar 路径
        String jarPath = System.getProperty("user.dir") + File.separator + "agent/target" + File.separator + "testAgent.jar";
        System.out.println("this redefine jar path:" + jarPath);


        try {
            VirtualMachine vm = VirtualMachine.attach(pid);	// 待绑定的jvm进程的pid号
            // 运行最终 AgentMain 中方法
            vm.loadAgent(jarPath, classPath);
        } catch (Throwable e) {
            System.err.println("ERROR:" + e.getMessage());
            e.printStackTrace();
        }
    }

}
