package com.ibeidan.web.nio.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lee
 * @DATE 2020/2/29 12:18
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(8088);
        System.out.println("server 阻塞开始 =" +System.currentTimeMillis());
        int i = 1;
        while (i ==1){
            Socket socket= serverSocket.accept();
            System.out.println("server 阻塞结束="+System.currentTimeMillis());
           /* BeginThread beginThread =new BeginThread(socket);
            beginThread.start();*/
           executorService.submit(new BeginThread(socket));

        }
        serverSocket.close();
    }



}
