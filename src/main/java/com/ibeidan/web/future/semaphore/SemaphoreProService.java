package com.ibeidan.web.future.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lee
 *  2020/1/3 14:28
 *  限制了并发线程数的功能，syncronized是不提供的
 */
public class SemaphoreProService {


    private volatile Semaphore setSemaphore = new Semaphore(10);//10个生产者

    private volatile Semaphore getSemaphore = new Semaphore(20);//20个消费者

    private volatile ReentrantLock reentrantLock =new ReentrantLock();

    private volatile Condition setCondition = reentrantLock.newCondition();

    private volatile Condition getConditon = reentrantLock.newCondition();

    private volatile Object[] producePosition = new Object[4];//4个菜盘

    private boolean isEmpty(){
        boolean isEmpty = true;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] !=null){
                isEmpty = false;
                break;
            }
        }
        if (isEmpty == true){
            return true;
        }else
            return false;
    }

    private boolean isFull(){
        boolean isFull = true ;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void produce(){
        System.out.println("生产开始");
        try {
            setSemaphore.acquire();//最多允许同时10个厨师进行生产
            reentrantLock.lock();
            while (isFull()){
                System.out.println("生产者开始等待---");
                setCondition.await();
            }

            for (int i = 0; i < producePosition.length; i++) {
                if (producePosition[i] == null){
                    producePosition[i] = "数据"+(i+1);
                    System.out.println(Thread.currentThread().getName()+"生产了" + producePosition[i]);
                    break;
                }
            }
            getConditon.signalAll();
            reentrantLock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            setSemaphore.release();
        }

    }

    public void consume(){
        System.out.println("消费开始");
        try {
            getSemaphore.acquire();//允许同时最多16个就餐者
            reentrantLock.lock();
            while (isEmpty()){
                System.out.println("消费者在等待");
                getConditon.await();
            }

            for (int i = 0; i < producePosition.length; i++) {
                if (producePosition[i] != null){
                    System.out.println(Thread.currentThread().getName()+" 消费了 "+producePosition[i]);
                    producePosition[i] = null;
                    break;
                }
            }
            setCondition.signalAll();
            reentrantLock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            getSemaphore.release();
        }
    }

}
