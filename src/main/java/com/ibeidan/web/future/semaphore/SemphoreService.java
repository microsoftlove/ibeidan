package com.ibeidan.web.future.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author lee
 *  2019/12/30 11:21
 *  semaphore 功能为synchronized关键字的升级版，但它提供的
 *  功能更加的强大与方便，主要的作用就是控制线程并发的数量。
 *
 *  公平信号量和非公平信号量
 *  所谓的公平信号量是获取锁的顺序与线程启动的顺序有关，但不代表100%地获得信号量，
 *  仅仅是在概率上能得到保证。
 *  而非公平信号量就是无关的了。
 */
public class SemphoreService {
    /**
     *
     * 构造参数permits是许可的意思，代表同一时间内，最多允许多少个线程同时执行acquire（）
     * 和release（）之间的代码。
     **/
    private Semaphore semaphore ;

    public SemphoreService(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    private int i ;

    public void testMethod(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " begin timer = "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println( " queueLength = "+semaphore.getQueueLength()+" waiting semaphore flag ="+semaphore.hasQueuedThreads());

            i++;
            System.out.println("=="+Thread.currentThread().getName() + " end timer = "+System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author libeibei
     * 2019/12/30 15:09
     * @param  permits 每调用一次acquire方法，就使用X个许可。
     **/
    public void testAcquireMethod(int permits){
        try {
            semaphore.acquire(permits);
            System.out.println(Thread.currentThread().getName() + " begin timer = "+System.currentTimeMillis());
            int sleepValue = ((int) (Math.random()*10000));
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " 停止了 "+(sleepValue/1000) +"秒！");
            System.out.println(Thread.currentThread().getName() + " end timer = "+System.currentTimeMillis());
            semaphore.release(permits);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author libeibei
     * 2019/12/31 16:23
     * @param  permits 每调用一次acquire方法，就使用X个许可
     * acquireUninterruptibly()等待许可的情况下不允许中断
     **/
    public void testAcquireUninterruptiblyMethod(int permits){

       /* try {
            semaphore.acquire(permits);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       semaphore.acquireUninterruptibly(permits);
        System.out.println(Thread.currentThread().getName() + " begin timer = "+System.currentTimeMillis());
        int sleepValue = ((int) (Math.random()*10000));
        try {
            Thread.sleep(sleepValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end timer = "+System.currentTimeMillis());

        semaphore.release(permits);

    }
}
