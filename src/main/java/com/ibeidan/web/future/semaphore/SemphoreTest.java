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

        /*Semaphore semaphore = new Semaphore(2);
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

       /* Semaphore semaphore2 = new Semaphore(10);
        SemphoreService semphoreService1 = new SemphoreService(semaphore2);
        ThreadAcquire[] acquires = new ThreadAcquire[10];
        for (int i = 0; i < 10; i++) {
            acquires[i]= new ThreadAcquire(semphoreService1,1);
            acquires[i].start();
        }*/

       // testAcquireUnInteruptable();

       // testMoreToOne();
       // testPool();

        testPro();
    }

    /**
     * @author libeibei
     * 2019/12/31 16:30
     **/
    public static void testAcquireUnInteruptable(){
        Semaphore semaphore = new Semaphore(1);
        int permits = 1;
        SemphoreService semphoreService = new SemphoreService(semaphore);
        ThreadAcquireUnInterruptilyA a = new ThreadAcquireUnInterruptilyA(semphoreService,permits);
        a.setName("A");

        ThreadAcquireUnInterruptilyB b = new ThreadAcquireUnInterruptilyB(semphoreService,permits);
        b.setName("B");

        a.start();
        b.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.interrupt();
        System.out.println("main 中断了 a");

    }

    public static void testMoreToOne(){
        Semaphore semaphore = new Semaphore(3);
        SemaphoreMoreToOneService semphoreMoreToOneService
                = new SemaphoreMoreToOneService(semaphore);
        ThreadMoreToOne[] moreToOnes =new ThreadMoreToOne[12];
        for (int i = 0; i < moreToOnes.length; i++) {
            moreToOnes[i] = new ThreadMoreToOne(semphoreMoreToOneService);
            moreToOnes[i].start();
        }


    }

    public static void testPool (){
        SemaphorePoolService semaphorePoolService = new SemaphorePoolService();
        ThreadPool[] threadPools = new ThreadPool[12];
        for (int i = 0; i < threadPools.length; i++) {
            threadPools[i] = new ThreadPool(semaphorePoolService);
        }

        for (int i = 0; i < threadPools.length; i++) {
            threadPools[i].start();
        }
    }

    public static void testPro(){
        SemaphoreProService semaphoreProService = new SemaphoreProService();
        ThreadProduce[] produces = new ThreadProduce[20];
        ThreadConsume[] consumes = new ThreadConsume[20];

        for (int i = 0; i < produces.length; i++) {
            produces[i] = new ThreadProduce(semaphoreProService);
            consumes[i] = new ThreadConsume(semaphoreProService);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < produces.length ; i++) {
            produces[i].start();
            consumes[i].start();
        }
    }


}
