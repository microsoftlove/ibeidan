package com.ibeidan.web.future.completionservice;

import java.util.concurrent.*;

/**
 * @author lee
 * @DATE 2019/12/30 10:26
 */
public class CompletionServiceExceptionTest {

    public static void main(String[] args) {

        MyCallableException myCallableException = new MyCallableException();
        MyCallableNoException myCallableNoException = new MyCallableNoException();

        Executor executor = Executors.newSingleThreadExecutor();
        CompletionService completionService = new ExecutorCompletionService(executor);
        completionService.submit(myCallableException);
        completionService.submit(myCallableNoException);


        for (int i = 0; i < 2; i++) {
            try {
                //System.out.println("zzzzzzz == "+completionService.take());//调用take 不抛出异常
                //System.out.println("zzzzzzz == "+completionService.take().get());//调用take 不抛出异常
                System.out.println("zzzzzzz == "+completionService.poll().get());//

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("main end!");

    }
}
