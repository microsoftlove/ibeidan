package com.ibeidan.web.future.queue;

/**
 * @author lee
 *  2020/4/20 13:43
 */
public class MyThreadMap1 extends Thread {

    private MyServiceMap serviceMap;

    public MyThreadMap1(String name, MyServiceMap serviceMap) {
        super(name);
        this.serviceMap = serviceMap;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            serviceMap.map.put("ThreadA"+(i+1),"ThreadA"+i+1);
            System.out.println("ThreadA"+(i+1));
        }
    }
}
