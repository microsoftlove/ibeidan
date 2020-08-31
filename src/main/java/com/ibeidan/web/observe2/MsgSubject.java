package com.ibeidan.web.observe2;

import java.util.Observable;

/**
 * @author lee
 * DATE 2020/8/28 14:44
 */
public class MsgSubject extends Observable {

    public void receiveMsg(String msg){
        System.out.println("MsgSubject接收到消息:" + msg);
        super.setChanged();
        super.notifyObservers(msg);
    }

}
