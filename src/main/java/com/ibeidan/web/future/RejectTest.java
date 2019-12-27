package com.ibeidan.web.future;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author lee
 * @DATE 2019/12/25 14:26
 */
public class RejectTest {

    public static void main(String args []){


        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setRejectedExecutionHandler(new MyRejectedExecutionHandler());

        Future future = executorService.submit(new MyRunnable(new UserInfo("1","")));
        Future future2 = executorService.submit(new MyRunnable(new UserInfo("2","")));
        executorService.shutdown();
        Future future3 = executorService.submit(new MyRunnable(new UserInfo("3","")));

        System.out.println("main A " + new Date());
        try {
            System.out.println("future.get =" + future.get(1000, TimeUnit.MILLISECONDS)+" done= " +future.isDone());
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
