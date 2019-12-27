package com.ibeidan.web.future;

/**
 * @author lee
 * @DATE 2019/12/24 11:38
 */
public class MyRunnable2 implements Runnable {
    private UserInfo2 userInfo;

    public MyRunnable2(UserInfo2 userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        userInfo.setUserName("libeibei2");
        userInfo.setPassWord("****");
    }
}
