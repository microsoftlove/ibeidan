package com.ibeidan.web.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lee
 * DATE 2020/4/23 19:11
 *
 * 子线程pool-1-thread-1可以获取到父线程在local里面设置的值，
 * 这就实现了值的传递了。
 */
public class MyInheritableThreadLocal {

    static ThreadLocal<String> local = new InheritableThreadLocal<>();

    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        MyInheritableThreadLocal my = new MyInheritableThreadLocal();
        my.test();
    }


    private void test(){
        local.set("我是天王");
        poolExecutor.submit(new Task());

    }

    class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+""+local.get());
        }
    }
}
