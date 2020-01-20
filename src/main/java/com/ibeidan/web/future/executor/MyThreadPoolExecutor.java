package com.ibeidan.web.future.executor;

import com.ibeidan.util.ThreadUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lee
 * @DATE 2020/1/20 16:56
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {



    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                                long keepAliveTime, TimeUnit unit,
                                BlockingQueue<Runnable> blockingQueue){
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, blockingQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        ThreadUtil.outThreadName("beforeExecute执行完了");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        ThreadUtil.outThreadName("afterExecute执行完了");
    }
}
