package com.ibeidan.web.future.cyclicbarrier;

/**
 * @author lee
 * @DATE 2020/1/7 17:18
 */
public class ThreadCyclic extends Thread {


    private CyclicBarrierService cyclicBarrierService;

    public ThreadCyclic(CyclicBarrierService cyclicBarrierService) {
        this.cyclicBarrierService = cyclicBarrierService;
    }

    @Override
    public void run() {
       // cyclicBarrierService.testAwait();
        cyclicBarrierService.testWaitTimeOut();
    }
}
