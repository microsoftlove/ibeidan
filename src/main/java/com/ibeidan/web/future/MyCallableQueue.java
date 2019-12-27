package com.ibeidan.web.future;


import java.util.concurrent.Callable;

/**
 * @author lee
 * @DATE 2019/12/24 10:55
 */
public  class MyCallableQueue implements Callable {

    private String  name;
    private Long sleepTime;


    public MyCallableQueue() {
    }

    public MyCallableQueue(String name, Long sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(name + "正在运行中……");
        Thread.sleep(sleepTime);

        return name+ "返回值 sleepTime是：" + sleepTime;
    }
}
