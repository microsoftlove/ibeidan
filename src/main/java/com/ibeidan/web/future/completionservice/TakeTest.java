package com.ibeidan.web.future.completionservice;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author lee
 * DATE 2019/12/27 10:50
 * 取得最先完成任务的future对象，谁执行时间最短谁最先返回
 * 如果当前没有任务被执行完，则还是呈阻塞特性。
 */
public class TakeTest {
    public static void main(String[] args){

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService completionService = new ExecutorCompletionService(executorService);
        for (int i = 0; i < 10; i++) {
            completionService.submit(new MyTakeCallable());
        }


        for (int i = 0; i < 10; i++) {
            try {
               System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

   static class MyTakeCallable implements Callable{

        @Override
        public Object call() throws Exception {
            long sleepVale = (long) (Math.random()*1000);
            System.out.println(Thread.currentThread().getName()+" sleep time "+sleepVale+" "+ new Date());
            Thread.sleep(sleepVale);
            return "libeibei: "+sleepVale+" "+Thread.currentThread().getName();
        }
    }

}
