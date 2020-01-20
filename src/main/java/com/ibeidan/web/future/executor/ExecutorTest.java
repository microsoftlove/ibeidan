package com.ibeidan.web.future.executor;

import com.ibeidan.util.ThreadUtil;
import com.ibeidan.web.future.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author lee
 * 2020/1/8 11:24
 */
public class ExecutorTest {


    public static void main(String[] args) {

      //testMythreadFactory();
        //testFixedThreadCount();
       testSingleThread();
    }

    public static void testMythreadFactory(){
        ThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);//无界队列

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                ThreadUtil.outThreadName("1开始运行---");
                ThreadUtil.sleep(1000);
                ThreadUtil.outThreadName("A");
                ThreadUtil.outThreadName("1运行结束");
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                ThreadUtil.outThreadName("2开始运行---");
                ThreadUtil.sleep(1000);
                ThreadUtil.outThreadName("B");
                ThreadUtil.outThreadName("2运行结束");
            }
        });
    }

    static void  testFixedThreadCount(){
       ExecutorService executorService =  Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new MyExecutorRunnalbe((i+1)+""));
        }

        for (int i = 0; i < 3; i++) {
            executorService.submit(new MyExecutorRunnalbe((i+1)+""));
        }



    }

    /**
     * @author libeibei
     * 2020/1/8 17:14
     * 单一的线程池可以实现以队列的形式来执行任务
     **/
    static void testSingleThread(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            executorService.submit(new MyExecutorRunnalbe((i+1)+""));
        }



    }

}
