package com.ibeidan.web.future.cyclicbarrier;

import com.ibeidan.util.ThreadUtil;

import java.util.concurrent.CyclicBarrier;

/**
 * @author lee
 * @DATE 2020/1/7 17:22
 */
public class CyclicTest {


    public static void main(String[] args) {

        testWait();
    }

    public static void testWait(){
        //5 设置最大为5个的parties同行者，也就是5个线程都执行了cyclicBarrier对象的await方法后程序才可以继续向下运行
        //否则这些线程彼此互相等待，一直呈阻塞状态。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                ThreadUtil.outThreadName("全都到了！");
            }
        });
        CyclicBarrierService cyclicBarrierService = new CyclicBarrierService(cyclicBarrier);
        ThreadCyclic[] threadCyclic =new ThreadCyclic[5];
        for (int i = 0; i < threadCyclic.length; i++) {
            threadCyclic[i] = new ThreadCyclic(cyclicBarrierService);
        }

        for (int i = 0; i < threadCyclic.length; i++) {
            threadCyclic[i].start();
        }
    }
}
