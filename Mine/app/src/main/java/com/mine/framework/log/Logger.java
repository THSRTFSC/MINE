package com.mine.framework.log;

import android.util.Log;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 *     1. 包装系统Log, 便于更新，扩展，维护。
 *     2. 后期可改为装饰者模式进行重构代码
 * </p>
 * Created by Alan on 18/1/6.
 */

public final class Logger {

    /**
     * 禁止被创建实例
     */
    private Logger () {

    }

    public static void v(String tag, String message) {
        Log.v(tag, message);
    }

    public static void v(String tag, String message, Throwable throwable) {
        Log.v(tag, message, throwable);
    }

    public static void d(String tag, String message) {
        Log.d(tag, message);
    }

    public static void d(String tag, String message, Throwable throwable) {
        Log.d(tag, message, throwable);
    }

    public static void i(String tag, String... messages) {
        Log.i(tag, LogFormater.logFormater(messages));
    }

    public static void i(String tag, String message, Throwable throwable) {
        Log.i(tag, message, throwable);
    }

    public static void w(String tag, String message) {
        Log.w(tag, message);
    }

    public static void w(String tag, String message, Throwable throwable) {
        Log.w(tag, message, throwable);
    }

    public static void w(String tag, Throwable throwable) {
        Log.w(tag, throwable);
    }

    public static void e(String tag, String message) {
        Log.e(tag, message);
    }

    public static void e(String tag, String message, Throwable throwable) {
        Log.e(tag, message, throwable);
    }

}
