package com.ibeidan.web.future.executerservice;

import java.util.concurrent.Callable;

/**
 * @author lee
 *  2020/4/14 13:36
 */
public class MyCallableC implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("MyCallableC begin " + System.currentTimeMillis());
        for (int i = 0; i < 1234; i++) {

            if (Thread.currentThread().isInterrupted() == false){
                Math.random();
                Math.random();
                Math.random();
                System.out.println("MyCallableC i ="+(i+1));
            }else {
                System.out.println("-------MyCallableC 抛出异常，中断了。");
            }

        }
        System.out.println("MyCallableC end " + System.currentTimeMillis());
        return "returnC";
    }
}
