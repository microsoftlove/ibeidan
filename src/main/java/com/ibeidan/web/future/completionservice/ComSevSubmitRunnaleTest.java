package com.ibeidan.web.future.completionservice;

import com.ibeidan.web.future.MyRunnable;
import com.ibeidan.web.future.UserInfo;

import java.util.concurrent.*;

/**
 * @author lee
 * @DATE 2019/12/30 10:42
 */
public class ComSevSubmitRunnaleTest {


    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        MyRunnable myRunnable = new MyRunnable(userInfo);

        Executor executor = Executors.newSingleThreadExecutor();
        CompletionService completionService =new  ExecutorCompletionService(executor);

        Future<UserInfo> future = completionService.submit(myRunnable,userInfo);
        try {
            UserInfo o = future.get();
            if (o != null){
                System.out.println(o.getUserName()+":"+ o.getPassWord() );
            }else {
                System.out.println("get userInfo null !");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }

}
