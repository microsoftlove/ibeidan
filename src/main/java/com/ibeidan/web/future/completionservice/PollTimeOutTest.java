package com.ibeidan.web.future.completionservice;

import java.util.concurrent.*;

/**
 * @author lee
 * DATE 2019/12/27 11:07
 * 等待指定的timeout时间，在timeout时间内获取到值时，
 * 立即向下执行，如果超时也立即向下执行。
 *
 */
public class PollTimeOutTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService completionService =new ExecutorCompletionService(executorService);


            completionService.submit(new MyPollTimeOutCallableA());
            completionService.submit(new MyPollTimeOutCallableB());


        for (int i = 0; i < 2; i++) {
           // System.out.println("zzzzzzz="+completionService.poll());//无阻塞
            try {
                System.out.println("zzzzzz=" +completionService.poll(4,TimeUnit.SECONDS).get());

                System.out.println("zzzzzz=" +completionService.poll(6,TimeUnit.SECONDS).get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main end !");

    }

   static class MyPollTimeOutCallableA implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(5000l);
            System.out.println("MyPollTimeOutCallableA "+System.currentTimeMillis());
            return "returnA";
        }
    }

    static class MyPollTimeOutCallableB implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(5000l);
            System.out.println("MyPollTimeOutCallableB "+System.currentTimeMillis());
            return "returnB";
        }
    }

}
