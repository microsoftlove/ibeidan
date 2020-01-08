package com.ibeidan.web.future.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lee
 * 2020/1/8 11:05
 */
public class ExecutorService {

    private Executor executor;

    public ExecutorService(Executor executor) {
        this.executor = executor;
    }

    public void testExecutor(){

        executor = new ThreadPoolExecutor(1,1,1000,null,null);
    }
}
