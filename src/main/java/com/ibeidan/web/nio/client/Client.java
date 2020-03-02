package com.ibeidan.web.nio.client;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lee
 * @DATE 2020/2/29 12:18
 */
public class Client {
    public static void main(String[] args)throws Exception {
        System.out.println("client 连接准备 ="+System.currentTimeMillis());
        Socket socket = new Socket("localhost",8088);
        System.out.println("client 连接结束 ="+System.currentTimeMillis());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("111".getBytes());
        outputStream.write("111111".getBytes());
        outputStream.write("11111111".getBytes());
        Thread.sleep(5000000000l);
        socket.close();

    }
}
