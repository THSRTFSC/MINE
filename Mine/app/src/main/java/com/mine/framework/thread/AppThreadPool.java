package com.mine.framework.thread;

import com.mine.utils.MINEUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定义应用全局的线程池，如果需要创建子线程则使用该类统一管理
 *
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/11/23.
 */

public class AppThreadPool {

    /**
     * CPU 个数
     */
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    /**
     * 线程空闲存活时间
     */
    private static int THREAD_KEEP_ALIVE_TIME = 60;

    /**
     * 线程名
     */
    private volatile static String THREAD_NAME = "MINE";

    private static final ExecutorService mExecutorService =
            new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES, THREAD_KEEP_ALIVE_TIME, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), MINEUtils.threadFactory(THREAD_NAME, false));

    private AppThreadPool() {
    }

    public static void execute(Runnable runnable) {
        mExecutorService.execute(runnable);
    }

    public static void shutDown() {
        mExecutorService.shutdown();
    }

}
