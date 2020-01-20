package com.ibeidan.web.future.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lee
 * 2020/1/2 15:37
 * 类semaphore可以有效地对并发执行任务的线程数量进行限制，
 * 这种功能可以应用在pool池技术中，可以设置同时访问pool池中的线程数量
 * 本实验的功能是同时有若干个线程可以访问池中的数据，但同时只有一个线程可以取得数据，
 * 使用完毕后再放回池中
 *
 */
public class SemaphorePoolService {

    private int poolMaxSize  = 5;
    private int semaphorePermits = 5;
    private List<String> list = new ArrayList<>();
    private Semaphore concurrencySemaphore = new Semaphore(semaphorePermits);
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public SemaphorePoolService() {
        for (int i = 0; i < poolMaxSize; i++) {
            list.add(" hi "+(i+1));
        }
    }

    public String get(){
        String getStr = null;
        try {
            concurrencySemaphore.acquire();
            reentrantLock.lock();
            while (list.size()==0){
                condition.await();
            }
            getStr = list.remove(0);
            reentrantLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            concurrencySemaphore.release();
        }

        return getStr;
    }

    public void put(String strValue){
        try {
            concurrencySemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.lock();
        list.add(strValue);
        condition.signalAll();
        reentrantLock.unlock();
        concurrencySemaphore.release();
    }
}
