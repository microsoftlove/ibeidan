package com.ibeidan.web.future;


import java.util.concurrent.Callable;

/**
 * @author lee
 * @DATE 2019/12/24 10:55
 */
public  class MyCallable implements Callable {

    private int age;

    public MyCallable() {
    }

    public MyCallable(int age) {
        this.age = age;
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(8000);

        int i=0;
        while (i == 0){
           if (Thread.currentThread().isInterrupted()){
               throw  new InterruptedException();
           }
           System.out.println("正在运行中……");
        }
        return "返回值 年龄是：" + age;
    }
}
