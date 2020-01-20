package com.ibeidan.web.future.executor;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * @author lee
 *  2020/1/19 15:14
 */
public class MyThreadFactoryExeception implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("新名字：" + new Date());
        newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("自定义处理异常启用："+t.getName()+" "+e.getMessage());
                e.printStackTrace();
            }
        });
        return newThread;
    }
}
