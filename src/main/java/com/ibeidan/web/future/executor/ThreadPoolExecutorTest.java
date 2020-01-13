package com.ibeidan.web.future.executor;

import com.ibeidan.util.ThreadUtil;
import com.ibeidan.web.future.MyRunnable;
import com.ibeidan.web.future.UserInfo;

import java.util.concurrent.*;

/**
 * @author lee
 * 2020/1/13 15:06
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        //testLessCorePool();
        testMoreCorePool();
    }

    /**
     * 由于线程数量<=7，所以倒数第2个打印为7，说明corePool核心池中的线程超过5秒钟不清除。
     * 此试验验证第一种场景：execute（runnable）欲执行的runnable的数量<=corePoolSize,
     * 那么马上创建线程运行这个任务，并不放入扩展队列Queue中，其它参数功能忽略。
     **/
    public static void testLessCorePool(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        //System.out.println(executor.getCorePoolSize()+ "=="+executor.getMaximumPoolSize());
        for (int i = 0; i < 7; i++) {
            executor.submit(new MyRunnableP());
        }

        ThreadUtil.sleep(300);
        System.out.println("A:"+executor.getCorePoolSize());//车中可载人的标准人数
        System.out.println("A:"+executor.getMaximumPoolSize());//车中可载人的最大人数
        System.out.println("A:"+executor.getPoolSize());//车中正在载的人数
        System.out.println("A:"+executor.getQueue().size());//扩展车中正在载的人数
        ThreadUtil.sleep(3000);
        System.out.println("B:"+executor.getCorePoolSize());
        System.out.println("B:"+executor.getPoolSize());
        System.out.println("B:"+executor.getQueue().size());
        /*ThreadPoolExecutor executor2 = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        System.out.println(executor.getCorePoolSize()+ "=="+executor.getMaximumPoolSize());
*/
    }

    /**
     *队列使用LinkedBlockingDeque类，也就是如果线程数量>corePoolSize时将其余的任务放入队列中
     * 同一时间最多只有7个线程在运行，如果使用LinkedBlockingDeque类则getMaximumPoolSize参数作用
     * 将忽略
     * 此试验验证第一种场景：execute（runnable）欲执行的runnable的数量>corePoolSize,<maximumPoolSize,
     * 并且是LinkedBlockingDeque，则maximumPoolSize和参数keepalivetime忽略，并把剩余的线程放入队列中
     * 等待被执行。
     **/
    public static void testMoreCorePool(){
        ThreadPoolExecutor exe = new ThreadPoolExecutor(7,8,5,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());

        for (int i = 0; i < 8; i++) {
            exe.submit(new MyRunnableP());
        }

        ThreadUtil.sleep(300);
        System.out.println("A:"+exe.getCorePoolSize());//车中可载人的标准人数
        System.out.println("A:"+exe.getMaximumPoolSize());//车中可载人的最大人数
        System.out.println("A:"+exe.getPoolSize());//车中正在载的人数
        System.out.println("A:"+exe.getQueue().size());//扩展车中正在载的人数
        ThreadUtil.sleep(3000);
        System.out.println("B:"+exe.getCorePoolSize());
        System.out.println("B:"+exe.getPoolSize());
        System.out.println("B:"+exe.getQueue().size());
    }
}
