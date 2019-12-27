package com.ibeidan.web.future;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author lee
 * @DATE 2019/12/24 10:01
 */
public class FutureTest {


    public static void main(String args []){
        MyCallable myCallable = new MyCallable(100);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());

        Future<String> future = executor.submit(myCallable);
        System.out.println("main A " + new Date());
        try {

           // System.out.println("future.cancel =" + future.cancel(true)+" "+ future.isCancelled());

            System.out.println("future.get =" + future.get(1000,TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("future.cancel =" + future.cancel(true)+" "+ future.isCancelled());

        }
        System.out.println("main B " + new Date());
    }

}
