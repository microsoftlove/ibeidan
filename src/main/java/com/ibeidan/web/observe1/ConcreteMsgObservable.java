package com.ibeidan.web.observe1;

/**
 * @author lee
 * DATE 2020/8/28 14:24
 */
public  class ConcreteMsgObservable extends AbstractMsgObservable {

    public void receiveMsg(String msg){
        super.notiftyMsgObservers(msg);
    }
}
