package com.ibeidan.web.extend;

/**
 * @author lee
 * @DATE 2020/4/21 14:43
 */
public class MyShotDownThread extends Thread {

    @Override
    public void run() {
        System.out.println("自定义 addShutdownHook关闭方法"+Thread.currentThread().getName());
    }


}
