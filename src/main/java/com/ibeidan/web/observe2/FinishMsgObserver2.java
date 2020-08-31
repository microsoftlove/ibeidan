package com.ibeidan.web.observe2;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lee
 * DATE 2020/8/28 14:44
 */
public class FinishMsgObserver2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("FinishMsgObserver2 收到消息 :"+arg);
    }
}
