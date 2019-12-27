package com.ibeidan.web.future.completionservice;



import com.ibeidan.web.future.MyCallableQueue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author lee
 * @DATE 2019/12/27 09:52
 */
public class FutureNoBlockTest {

    public static void main(String[] args){

        MyCallableQueue myCallableQueue1 = new MyCallableQueue("one",5000l);
        MyCallableQueue myCallableQueue2 = new MyCallableQueue("two",4000l);
        MyCallableQueue myCallableQueue3 = new MyCallableQueue("three",3000l);
        MyCallableQueue myCallableQueue4 = new MyCallableQueue("four",2000l);
        MyCallableQueue myCallableQueue5 = new MyCallableQueue("five",1000l);

        List<Callable> callableList = new ArrayList<>();
        callableList.add(myCallableQueue1);
        callableList.add(myCallableQueue2);
        callableList.add(myCallableQueue3);
        callableList.add(myCallableQueue4);
        callableList.add(myCallableQueue5);

        List<Future> futureList =new ArrayList<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,
                5, TimeUnit.SECONDS, new LinkedBlockingDeque());
        CompletionService completionService = new ExecutorCompletionService(threadPoolExecutor);


        for (int i = 0; i < callableList.size(); i++) {
            futureList.add(completionService.submit(callableList.get(i)));
        }
        System.out.println("run first time "+ new Date());

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("等待打印第 "+ (i+1)+"个返回值。");
                System.out.println(completionService.take().get() +"==="+ new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
