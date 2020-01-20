package com.ibeidan.web.future.executor;

import com.ibeidan.util.ThreadUtil;
import com.ibeidan.web.future.UserInfo;

/**
 * @author lee
 * @DATE 2020/1/8 16:59
 */
public class MyExecutorRunnalbe implements Runnable {

    private String userInfo;

    public MyExecutorRunnalbe(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        ThreadUtil.outThreadName(userInfo+"开始运行---");
        ThreadUtil.sleep(1000);
        ThreadUtil.outThreadName(userInfo);
        ThreadUtil.outThreadName(userInfo+"运行结束");
    }
}
