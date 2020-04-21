package com.ibeidan.web.future.executerservice;

import java.util.concurrent.Callable;

/**
 * @author lee
 *  2020/4/14 13:36
 */
public class MyCallableB implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("MyCallableB begin " + System.currentTimeMillis());
        for (int i = 0; i < 123; i++) {

            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableB i ="+(i+1));
        }
        System.out.println("MyCallableB end " + System.currentTimeMillis());
        return "returnB";
    }
}
