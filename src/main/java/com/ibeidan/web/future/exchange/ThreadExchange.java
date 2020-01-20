package com.ibeidan.web.future.exchange;

import java.util.concurrent.Exchanger;

/**
 * @author lee
 * @DATE 2020/1/3 15:01
 */
public class ThreadExchange extends Thread {

    private Exchanger<String> exchanger;

    public ThreadExchange(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
            System.out.println("在线程A中得到线程B的值=" + exchanger.exchange("中国人A"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A end ！");
    }
}
