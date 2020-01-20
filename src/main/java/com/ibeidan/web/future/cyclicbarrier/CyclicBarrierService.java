package com.ibeidan.web.future.cyclicbarrier;

import com.ibeidan.util.ThreadUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lee
 *  2020/1/7 17:11
 *  不仅有countdownLatch所具有的功能，还可以实现屏障等待的功能，
 *  也就是阶段性的同步，它在使用上的意义在于可以循环地实现线程要一起做任务的目标。
 *  线程异常：使用全有或者全无的破坏模型。意思是如果有一个线程由于中断或者超时提前离开了屏障点，其它所有在屏障点
 *  等待的线程也会抛出异常，并且离开屏障点。
 */
public class CyclicBarrierService {

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    void testAwait(){
        try {
            Thread.sleep((long) (Math.random()*1000));
            ThreadUtil.outThreadName("到了！");
            ThreadUtil.outThreadName("已到达屏障点线程数："+cyclicBarrier.getNumberWaiting()+"");

            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }


    void testWaitTimeOut(){
        try {
            Thread.sleep((long) (Math.random()*1000));
            ThreadUtil.outThreadName("到了！");
            ThreadUtil.outThreadName("已到达屏障点线程数："+cyclicBarrier.getNumberWaiting()+"");

            //如果在指定的时间内到达parties的数量，则程序继续向下执行，否则如果出现超时，则抛出超时异常。
            cyclicBarrier.await(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


}
