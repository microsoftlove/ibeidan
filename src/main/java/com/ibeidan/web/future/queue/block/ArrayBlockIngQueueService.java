package com.ibeidan.web.future.queue.block;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lee
 *  2020/4/20 13:55
 * 所谓的阻塞队列BlockingQueue，其实就是如果BlockQueue是空的，
 * 从BlockQueue取东西的操作将会被阻塞进入等待状态，直到
 * BlockQueue添加进了元素才会被唤醒。
 * 同样，如果BlockQueue是满的，也就是没有空余空间时，试图往队列中存放元素的操作
 * 也会被阻塞进入等待状态，直到BlockQueue里有剩余空间才会被
 * 唤醒继续操作。
 *
 */
public class ArrayBlockIngQueueService {


    public static void main(String[] args) throws InterruptedException {
        //testPut();
        testTake();
    }


    public static void testPut() throws InterruptedException {
        ArrayBlockingQueue queue =new ArrayBlockingQueue(3);
        for (int i = 0; i < 3; i++) {
                queue.put(""+i);
        }
        System.out.println(System.currentTimeMillis());
        queue.put("4");
        System.out.println(System.currentTimeMillis());

    }

    public static void testTake() throws InterruptedException {
        ArrayBlockingQueue queue =new ArrayBlockingQueue(3);
        System.out.println(System.currentTimeMillis());
        queue.take();
        System.out.println(System.currentTimeMillis());
    }


}
