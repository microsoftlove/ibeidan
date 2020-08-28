package com.ibeidan.test.observer;

import com.ibeidan.web.observe1.*;
import org.junit.Test;

/**
 * @author lee
 * DATE 2020/8/28 14:32
 */
public class ObserverTest2 {

    @Test
    public void testObserver(){
        IMsgObserver iMsgObserver = new MsgObserver();
        IMsgObserver iMsgObserver1 = new MsgObserver2();

        ConcreteMsgObservable iMsgObservable = new ConcreteMsgObservable();
        iMsgObservable.addObserver(iMsgObserver);
        iMsgObservable.addObserver(iMsgObserver1);
        iMsgObservable.receiveMsg("hello");
    }
}
