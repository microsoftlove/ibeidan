package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2019/12/30 14:53
 */
public class ThreadAcquire extends Thread {

    private SemphoreService semphoreService;

    private int permits;




    public ThreadAcquire(SemphoreService semphoreService,int permits) {
        super();
        this.semphoreService = semphoreService;
        this.permits = permits;
    }

    public void run() {
        semphoreService.testAcquireMethod(permits);
    }
}
