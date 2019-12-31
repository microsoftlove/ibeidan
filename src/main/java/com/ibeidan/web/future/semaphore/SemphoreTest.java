package com.ibeidan.web.future.semaphore;


import java.util.concurrent.Semaphore;

/**
 * @author lee
 *  2019/12/30 11:09
 *  semaphore 功能为synchronized关键字的升级版，但它提供的
 *  功能更加的强大与方便，主要的作用就是控制线程并发的数量。
 */
public class SemphoreTest {



    public static void main(String[] args) {

        /*Semaphore semaphore = new Semaphore(1);
        SemphoreService semphoreService = new SemphoreService(semaphore);
        ThreadA a = new ThreadA(semphoreService);
        a.setName("A");

        ThreadB b = new ThreadB(semphoreService);
        b.setName("B");

        ThreadC c = new ThreadC(semphoreService);
        c.setName("C");

        a.start();
        b.start();
        c.start();*/

        Semaphore semaphore2 = new Semaphore(10);
        SemphoreService semphoreService1 = new SemphoreService(semaphore2);
        ThreadAcquire[] acquires = new ThreadAcquire[10];
        for (int i = 0; i < 10; i++) {
            acquires[i]= new ThreadAcquire(semphoreService1,2);
            acquires[i].start();
        }


    }

}
