package com.ibeidan.web.future.executerservice;

import java.util.concurrent.ExecutorService;

/**
 * @author lee
 * @DATE 2020/4/21 14:54
 */
public class MyShutDowHookThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"关闭线程");

    }


    private void shutDownGracefully(ExecutorService executorService){
        executorService.shutdown();

    }
}
