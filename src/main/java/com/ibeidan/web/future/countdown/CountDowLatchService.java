package com.ibeidan.web.future.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author lee
 * 2020/1/3 16:18
 *
 * Latch译为门闩的意思，当门闩没有打开时，N个人是不能进入屋内的。也就是不能继续向下运行的，支持这样的
 * 特性，可以控制线程执行任务的时机，使线程以"组团"的方式一起执行任务。
 */
public class CountDowLatchService {


    private CountDownLatch countDownLatch ;

    public CountDowLatchService(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void testMethod(){
        System.out.println("A");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B");
    }


    public void downMethod(){
        System.out.println("X");
        countDownLatch.countDown();
    }

    public void testDown(){
        System.out.println(countDownLatch.getCount()+"=="+Thread.currentThread().getName()+"开始执行");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        //System.out.println(countDownLatch.getCount()+"=="+Thread.currentThread().getName()+"结束执行");

    }



}
