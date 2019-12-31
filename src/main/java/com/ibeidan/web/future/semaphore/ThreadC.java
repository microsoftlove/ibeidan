package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2019/12/30 11:29
 */
public class ThreadC extends Thread {


    private SemphoreService semphoreService;

    public ThreadC(SemphoreService semphoreService) {
        super();
        this.semphoreService = semphoreService;
    }

     public void run() {
        semphoreService.testMethod();
     }
}
