package com.ibeidan.web.future;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author lee
 * @DATE 2019/12/24 10:01
 */
public class FutureSubmitTest {


    public static void main(String args []){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable print " + new Date());
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(runnable);
        System.out.println("main A " + new Date());
        try {
            System.out.println("future.get =" + future.get(10000,TimeUnit.MILLISECONDS)+" done= " +future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("main B " + new Date());
    }

}
