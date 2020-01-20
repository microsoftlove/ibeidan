package com.ibeidan.web.future.completionservice;

import java.util.concurrent.*;

/**
 * @author lee
 * DATE 2019/12/27 11:07
 * 获取并移除表示下一个已完成任务的Future，如果不存在这样的任务，则返回null,无阻塞的效果
 *
 */
public class PollTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService completionService =new ExecutorCompletionService(executorService);

        for (int i = 0; i < 1; i++) {
            completionService.submit(new MyPollCallable());
        }

        for (int i = 0; i < 1; i++) {
            System.out.println(completionService.poll());
        }

    }

   static class MyPollCallable implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(3000l);
            System.out.println("3s 过后了");
            return "李贝贝3s";
        }
    }

}
