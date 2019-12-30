package com.ibeidan.web.future.completionservice;

import java.util.concurrent.Callable;

/**
 * @author lee
 * @DATE 2019/12/30 10:27
 */
public class MyCallableException implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("MyCallableException begin"+System.currentTimeMillis());

        Thread.sleep(1000l);
        int i =0;
        if (i==0)
           throw new Exception("抛出异常！");
        System.out.println("MyCallableException end"+System.currentTimeMillis());

        return "MyCallableException";
    }
}
