package com.ibeidan.web.future.executor;

import java.util.concurrent.ThreadFactory;

/**
 * @author lee
 *  2020/1/8 11:36
 */
public class MyThreadFactory implements ThreadFactory {


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("我的自定义线程工程，定制线程名字"+Math.random());
        return thread;
    }
}
