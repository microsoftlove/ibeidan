package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2020/1/3 14:45
 */
public class ThreadConsume extends Thread {

    private SemaphoreProService semaphoreProService;

    public ThreadConsume(SemaphoreProService semaphoreProService) {
        this.semaphoreProService = semaphoreProService;
    }

    @Override
    public void run() {
        semaphoreProService.consume();
    }
}
