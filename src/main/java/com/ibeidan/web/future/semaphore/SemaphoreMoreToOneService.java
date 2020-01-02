package com.ibeidan.web.future.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lee
 *  2020/1/2 15:15
 *  多个线程同时处理任务，也就是每个线程处理自己的任务。
 */
public class SemaphoreMoreToOneService {

    private ReentrantLock lock = new ReentrantLock();

    private Semaphore semaphore;

    public SemaphoreMoreToOneService(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * @author libeibei
     * 2020/1/2 15:30
     * 多进路-多处理-多出路试验
     **/
    public void sayHello(){
        try {
            semaphore.acquire();
            System.out.println("threadname="+Thread.currentThread().getName()+" 准备……");
            System.out.println("begin hello"+System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" 打印 "+(i+1));
            }
            System.out.println("end hello"+System.currentTimeMillis());
            semaphore.release();
            System.out.println("threadname="+Thread.currentThread().getName()+" 结束……");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * @author libeibei
     * 2020/1/2 15:30
     * 多进路-单处理-多出路试验 加入lock对象保证了同步性
     **/
    public void sayHelloLock(){
        try {
            semaphore.acquire();
            lock.lock();
            System.out.println("threadname="+Thread.currentThread().getName()+" 准备……");

            System.out.println("begin hello"+System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" 打印 "+(i+1));
            }


            System.out.println("end hello"+System.currentTimeMillis());
            lock.unlock();
            semaphore.release();
            System.out.println("threadname="+Thread.currentThread().getName()+" 结束……");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
