package com.ibeidan.test.observer;

import com.ibeidan.web.observe2.FinishMsgObserver;
import com.ibeidan.web.observe2.FinishMsgObserver2;
import com.ibeidan.web.observe2.MsgSubject;
import com.sun.media.jfxmedia.track.Track;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author lee
 * DATE 2020/8/28 14:32
 */
public class ObserverTest3 {

    @Test
    public void testObserver(){
        FinishMsgObserver msgObserver = new FinishMsgObserver();
        FinishMsgObserver2 msgObserver2 = new FinishMsgObserver2();

        MsgSubject msgSubject = new MsgSubject();
        msgSubject.addObserver(msgObserver);
        msgSubject.addObserver(msgObserver2);

        msgSubject.receiveMsg("hello");
    }

    @Test
    public void testBase64(){

    }
}
