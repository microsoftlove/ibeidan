package com.ibeidan.web.future.countdown;

/**
 * @author lee
 * @DATE 2020/1/6 16:03
 */
public class ThreadCountDown extends Thread {

    private CountDowLatchService countDowLatchService;

    public ThreadCountDown(CountDowLatchService countDowLatchService) {
        this.countDowLatchService = countDowLatchService;
    }

    @Override
    public void run() {
       countDowLatchService.testDown();
    }
}
