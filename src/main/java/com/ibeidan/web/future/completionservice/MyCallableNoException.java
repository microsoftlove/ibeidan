package com.ibeidan.web.future.completionservice;

import java.util.concurrent.Callable;

/**
 * @author lee
 * @DATE 2019/12/30 10:27
 */
public class MyCallableNoException implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("MyCallableNoException begin"+System.currentTimeMillis());

        Thread.sleep(1000l);
        System.out.println("MyCallableNoException end"+System.currentTimeMillis());

        return "MyCallableNoException";
    }
}
