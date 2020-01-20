package com.ibeidan.web.future.executor;

import com.ibeidan.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @DATE 2020/1/13 15:19
 */
public class MyRunnableP implements Runnable {
    @Override
    public void run() {
        ThreadUtil.outThreadName("run---");
        ThreadUtil.sleep(2000);
        new ArrayList<>().get(3);
    }
}
