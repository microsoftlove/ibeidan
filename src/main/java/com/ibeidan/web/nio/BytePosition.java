package com.ibeidan.web.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lee
 * @DATE 2019/7/7 10:47
 */
public class BytePosition {

    public static void  main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/mnt/iss/web/a.txt");

        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(7);
        byteBuffer1.position(1);
        byteBuffer1.limit(3);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(7);
        byteBuffer2.position(2);
        byteBuffer2.limit(4);
        ByteBuffer[] byteBuffers= new ByteBuffer[]{byteBuffer1,byteBuffer2};
        fileChannel.read(byteBuffers);
        fileChannel.close();
        fis.close();
        byteBuffer1.rewind();
        byteBuffer2.rewind();

        for (int i =0;i<byteBuffers.length;i++){
            ByteBuffer eachBuffer = byteBuffers[i];
            byte [] byteArray = eachBuffer.array();
            for (int j =0;j<byteArray.length;j++){
                byte eachByte = byteArray[j];
                if (eachByte ==0){
                    System.out.println("空格");
                }else {
                    System.out.println((char)byteArray[j]);
                }
            }
            System.out.println();
        }

    }
}
