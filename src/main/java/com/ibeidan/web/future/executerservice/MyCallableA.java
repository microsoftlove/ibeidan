package com.ibeidan.web.future.executerservice;

import java.util.concurrent.Callable;

/**
 * @author lee
 *  2020/4/14 13:36
 */
public class MyCallableA implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("MyCallableA begin " + System.currentTimeMillis());
        for (int i = 0; i < 1234; i++) {

            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableA i ="+(i+1));
        }
        System.out.println("MyCallableA end " + System.currentTimeMillis());
        return "returnA";
    }
}
