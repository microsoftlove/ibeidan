package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2019/12/30 11:29
 */
public class ThreadB extends Thread {


    private SemphoreService semphoreService;

    public ThreadB(SemphoreService semphoreService) {
        super();
        this.semphoreService = semphoreService;
    }

     public void run() {
        semphoreService.testMethod();
     }
}
