package com.gh.agent;


import lombok.extern.slf4j.Slf4j;
import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author sso team
 * @description
 * @date 2022/2/18 11:18 上午
 */
public class AgentMain {

    public static void agentmain(String agentArgs, Instrumentation inst) {

        // 从 agentArgs 获取外部参数
        System.out.println("开始热更新代码");
        // 这里将会传入 class 文件路径
        String path = agentArgs;
        try {
            // 读取 class 文件字节码
            RandomAccessFile f = new RandomAccessFile(path, "r");
            final byte[] bytes = new byte[(int) f.length()];
            f.readFully(bytes);
            // 使用 asm 框架获取类名
            final String clazzName = readClassName(bytes);

            // inst.getAllLoadedClasses 方法将会获取所有已加载的 class
            for (Class clazz : inst.getAllLoadedClasses()) {
                // 匹配需要替换 class
                if (clazz.getName().equals(clazzName)) {
                    ClassDefinition definition = new ClassDefinition(clazz, bytes);
                    // 使用指定的 class 替换当前系统正在使用 class
                    inst.redefineClasses(definition);
                }
            }

        } catch (UnmodifiableClassException | IOException | ClassNotFoundException e) {
            System.out.println("热更新数据失败");
        }
    }

    private static String readClassName(byte[] bytes) {
        return new ClassReader(bytes).getClassName().replace("/", ".");
    }

}
