package com.ibeidan.web.future.executor;

import com.ibeidan.util.ThreadUtil;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lee
 * @DATE 2020/1/20 16:15
 */
public class MyRecetcExection implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        ThreadUtil.outThreadName(r+"拒绝执行！");
    }
}
