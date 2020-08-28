package com.ibeidan.web.observe1;

public interface IMsgObservable {

    public void addObserver(IMsgObserver msgObserver);

    public void removeObserver(IMsgObserver msgObserver);

    public void notiftyMsgObservers(String msg);
}
