package com.ibeidan.web.future;

/**
 * @author lee
 * @DATE 2019/12/24 11:38
 */
public class MyRunnable implements Runnable {
    private UserInfo userInfo;

    public MyRunnable(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setUserName("libeibei");
        userInfo.setPassWord("****");
    }
}
