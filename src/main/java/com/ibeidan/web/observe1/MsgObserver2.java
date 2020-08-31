package com.ibeidan.web.observe1;

/**
 * @author lee
 * DATE 2020/8/28 14:36
 */
public class MsgObserver2 implements IMsgObserver {
    @Override
    public void update(String msg) {
        System.out.println("FinishMsgObserver2 收到消息：" + msg);
    }
}
