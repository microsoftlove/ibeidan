package com.ibeidan.web.future.semaphore;

/**
 * @author lee
 * @DATE 2020/1/2 15:50
 */
public class ThreadPool extends Thread {

    private SemaphorePoolService  semaphorePoolService;

    public ThreadPool(SemaphorePoolService semaphorePoolService) {
        this.semaphorePoolService = semaphorePoolService;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            String getStr = semaphorePoolService.get();
            System.out.println(Thread.currentThread().getName()+" 取得值 " +getStr);
            semaphorePoolService.put(getStr);
        }
    }
}
