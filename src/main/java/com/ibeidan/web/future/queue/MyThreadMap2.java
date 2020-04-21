package com.ibeidan.web.future.queue;

/**
 * @author lee
 *  2020/4/20 13:43
 */
public class MyThreadMap2 extends Thread {

    private MyServiceMap serviceMap;

    public MyThreadMap2(String name, MyServiceMap serviceMap) {
        super(name);
        this.serviceMap = serviceMap;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            serviceMap.map.put("ThreadB"+(i+1),"ThreadB"+i+1);
            System.out.println("ThreadB"+(i+1));
        }
    }
}
