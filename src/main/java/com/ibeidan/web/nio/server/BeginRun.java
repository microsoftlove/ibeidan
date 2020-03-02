package com.ibeidan.web.nio.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author lee
 * @DATE 2020/2/29 14:18
 */
public class BeginRun implements Runnable {

    private Socket socket;

    public BeginRun(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] charArray = new byte[10];
            int readLength =   inputStream.read(charArray);
            while (readLength != -1){
                String newstr = new String(charArray,0,readLength);
                System.out.println(newstr +"==="+ System.currentTimeMillis());
                readLength = inputStream.read(charArray);
            }
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
