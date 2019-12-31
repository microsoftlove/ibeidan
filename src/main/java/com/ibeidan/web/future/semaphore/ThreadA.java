package com.ibeidan.web.future.semaphore;

import java.io.Serializable;

/**
 * @author lee
 * @DATE 2019/12/30 11:29
 */
public class ThreadA extends Thread implements Serializable {


    private static final long serialVersionUID = 3575940470394526340L;
    private SemphoreService semphoreService;

    public ThreadA(SemphoreService semphoreService) {
        super();
        this.semphoreService = semphoreService;
    }

     public void run() {
        semphoreService.testMethod();
     }
}
