package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2020/1/2 15:21
 */
public class ThreadMoreToOne extends Thread {

    private SemaphoreMoreToOneService semphoreMoreToOneService;

    public ThreadMoreToOne(SemaphoreMoreToOneService semphoreMoreToOneService) {
        super();
        this.semphoreMoreToOneService = semphoreMoreToOneService;
    }

    public void run(){
        //semphoreMoreToOneService.sayHello();
        semphoreMoreToOneService.sayHelloLock();
    }
}
