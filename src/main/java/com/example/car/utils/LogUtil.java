package com.example.car.utils;

import org.apache.log4j.Logger;

/**
 * 打印日志
 * <br>
 * created date 2021/4/25 12:58
 *
 * @author yh
 */
public class LogUtil {
    public static void trace(String msg) {
        getLogger().trace(msg);
    }

    public static void debug(String msg) {
        getLogger().debug(msg);
    }

    public static void info(String msg) {
        getLogger().info(msg);
    }

    public static void warn(String msg) {
        getLogger().warn(msg);
    }

    public static void error(String msg) {
        getLogger().error(msg);
    }

    public static void error(String msg, Throwable t) {
        getLogger().error(msg, t);
    }

    private static Logger getLogger() {
        return Logger.getLogger(findCaller().getClassName());
    }

    private static StackTraceElement findCaller() {
        // 获取堆栈信息
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        // 最原始被调用的堆栈信息
        // StackTraceElement caller = null;
        // 日志类名称
        String logClassName = LogUtil.class.getName();
        // 循环遍历到日志类标识
        int i = 0;
        for (int len = callStack.length; i < len; i++) {
            if (logClassName.equals(callStack[i].getClassName())) {
                break;
            }
        }
        //是的没有错,这是一个magic number！想知道为什么？开启你的堆栈，来寻找我的宝藏吧！by Luo
        return callStack[i + 3];
    }

}
