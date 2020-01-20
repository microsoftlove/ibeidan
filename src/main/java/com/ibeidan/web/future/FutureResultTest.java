package com.ibeidan.web.future;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author lee
 * @DATE 2019/12/24 11:39
 */
public class FutureResultTest {

    FutureTask abc;
    public static void main(String args []) {
        UserInfo userInfo = new UserInfo();
        MyRunnable myRunnable = new MyRunnable(userInfo);
        UserInfo2 userInfo2 = new UserInfo2();
        MyRunnable2 myRunnable2 = new MyRunnable2(userInfo2);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,10,10, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        Future<UserInfo> future = poolExecutor.submit(myRunnable,userInfo);
        System.out.println("begin time == " +new Date());

        Future<UserInfo2> future2 = poolExecutor.submit(myRunnable2,userInfo2);
        System.out.println("begin2 time == " +new Date());
        try {
            userInfo2 = future2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("future2.get = " + userInfo2.toString());
        System.out.println("end2 time == " +new Date());

        try {
            userInfo = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("future.get = " + userInfo.toString());
        System.out.println("end time == " +new Date());

    }
    }
