package com.ibeidan.web.future.queue.block;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author lee
 * DATE 2020/5/6 14:21
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {
        PriorityBlockingQueue<UserInfo> priorityBlockingQueue = new PriorityBlockingQueue<UserInfo>();
        priorityBlockingQueue.add(new UserInfo(12));
        priorityBlockingQueue.add(new UserInfo(13478));
        priorityBlockingQueue.add(new UserInfo(1569));
        priorityBlockingQueue.add(new UserInfo(1762));

        System.out.println(priorityBlockingQueue.poll().getId());
        System.out.println(priorityBlockingQueue.poll().getId());

        System.out.println(priorityBlockingQueue.poll().getId());
        System.out.println(priorityBlockingQueue.poll().getId());

        System.out.println(priorityBlockingQueue.poll());

    }
}
