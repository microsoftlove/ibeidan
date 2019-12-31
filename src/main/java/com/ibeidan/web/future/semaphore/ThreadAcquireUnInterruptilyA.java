package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2019/12/30 14:53
 */
public class ThreadAcquireUnInterruptilyA extends Thread {

    private SemphoreService semphoreService;

    private int permits;




    public ThreadAcquireUnInterruptilyA(SemphoreService semphoreService, int permits) {
        super();
        this.semphoreService = semphoreService;
        this.permits = permits;
    }

    public void run() {
        semphoreService.testAcquireUninterruptiblyMethod(permits);
    }
}
