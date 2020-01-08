package com.ibeidan.web.future.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lee
 * @DATE 2020/1/6 16:05
 */
public class CountDownTest {

    public static void main(String[] args) {

       testDown();
    }


    public static void test(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDowLatchService countDowLatchService = new CountDowLatchService(countDownLatch);
        ThreadCountDown threadCountDown = new ThreadCountDown(countDowLatchService);
        threadCountDown.start();
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDowLatchService.downMethod();
    }


    public static void testDown(){
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDowLatchService countDowLatchService = new CountDowLatchService(countDownLatch);
        //此处业务线程可以处理各自的业务逻辑
        ThreadCountDown[] countDowns = new ThreadCountDown[10];
        for (int i = 0; i < countDowns.length; i++) {

            countDowns[i] = new ThreadCountDown(countDowLatchService);
            countDowns[i].setName("线程"+(i+1));

            countDowns[i].start();
        }

        try {
            System.out.println("等待回来……");
            //使线程在指定的最大时间单位内进入waiting状态，如果超过这个时间则自动唤醒，程序继续向下执行。
            boolean fl= countDownLatch.await(1, TimeUnit.SECONDS);
            System.out.println("等待回来……"+fl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("都回来了！");
    }
}
