package com.ibeidan.web.observe1;

/**
 * @author lee
 * DATE 2020/8/28 14:31
 */
public class MsgObserver implements IMsgObserver {

    @Override
    public void update(String msg) {
        System.out.println("MsgObserver 接收到消息：" + msg);
    }
}
