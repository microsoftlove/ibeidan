package com.ibeidan.web.future.executerservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lee
 *  2020/4/14 13:34
 */
public class Run1 {



    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new MyShutDowHookThread());

        List list = new ArrayList();
        list.add(new MyCallableA());
        //list.add(new MyCallableB());
        list.add(new MyCallableC());

        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            String getValeA = (String) executorService.invokeAny(list);
            System.out.println("getValeA========="+getValeA);
            System.out.println("zzzxxxxxxx");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }


    /**
     * Add shutdown hook.
     */
  /*  private void addShutdownHook(final FtpServer engine) {

        // create shutdown hook
        Runnable shutdownHook = new Runnable() {
            public void run() {
                System.out.println("Stopping server...");
                engine.stop();
            }
        };

        // add shutdown hook
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(shutdownHook));
    }*/
}
