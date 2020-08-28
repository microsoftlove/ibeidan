package com.ibeidan.web.observe1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * DATE 2020/8/28 14:25
 */
public abstract class AbstractMsgObservable implements IMsgObservable{

    private static List<IMsgObserver> msgObservers = new ArrayList<>();

    @Override
    public void addObserver(IMsgObserver msgObserver) {
        msgObservers.add(msgObserver);
    }

    @Override
    public void removeObserver(IMsgObserver msgObserver) {
        msgObservers.remove(msgObserver);
    }

    @Override
    public void notiftyMsgObservers(String msg) {
        for (IMsgObserver m:msgObservers) {
            m.update(msg);
        }
    }
}
