package com.ibeidan.web.future.exchange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lee
 * @DATE 2020/1/3 15:01
 */
public class ThreadExchangeB extends Thread {

    private Exchanger<String> exchanger;

    public ThreadExchangeB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程B中得到线程A的值=" + exchanger.exchange("中国人B",5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("B end ！");
    }
}
