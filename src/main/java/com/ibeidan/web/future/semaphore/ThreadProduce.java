package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2020/1/3 14:45
 */
public class ThreadProduce extends Thread {

    private SemaphoreProService semaphoreProService;

    public ThreadProduce(SemaphoreProService semaphoreProService) {
        this.semaphoreProService = semaphoreProService;
    }

    @Override
    public void run() {
        semaphoreProService.produce();
    }
}
