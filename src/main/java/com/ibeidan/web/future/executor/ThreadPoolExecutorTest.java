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
        //testMoreCorePool();
        //testSyncronous();
        //testAwaitTermination();
        //testAwaitTerminationShutDown();
        testException();
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

        for (int i = 0; i < 18; i++) {
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
    /**
     * A：执行的线程数量
     * B：corePoolSize
     * C：maximumPoolSize
     * D：A-B（假设A>=B）
     * E:代表LinkedBlockingDeque
     * F：SynchronousQueue
     * G：代表存活时间
     *
     **/

    /**
     *场景三：如果执行的线程数量大于corePoolSize&&<=maximumPoolSize&&为SynchronousQueue，则
     * C和D参数有效，并且马上创建线程执行这些任务，而不把D放入F中，D执行完任务后在指定时间后发生超时
     * 时将D进行清除。
     **/
    public static void testSyncronous(){
        ThreadPoolExecutor exe = new ThreadPoolExecutor(7,8,5,TimeUnit.SECONDS,
                new SynchronousQueue<>());

        for (int i = 0; i < 8; i++) {
            exe.submit(new MyRunnableP());
        }

        ThreadUtil.sleep(300);
        System.out.println("A:"+exe.getCorePoolSize());//车中可载人的标准人数
        System.out.println("A:"+exe.getMaximumPoolSize());//车中可载人的最大人数
        System.out.println("A:"+exe.getPoolSize());//车中正在载的人数
        System.out.println("A:"+exe.getQueue().size());//扩展车中正在载的人数
        ThreadUtil.sleep(10000);
        System.out.println("B:"+exe.getCorePoolSize());
        System.out.println("B:"+exe.getPoolSize());
        System.out.println("B:"+exe.getQueue().size());
        exe.shutdown();//当线程池调用shutdown方法时，线程池的状态则立刻变成SHUTDOWN状态，此时不能再往线程池
        //中添加任何任务，否则将会抛出RejectedExecutionException异常。但是此时线程池不会立刻退出，直到线程池中的
        //任务都已经处理完成，才会退出。
        //exe.shutdownNow();//此方法使线程池中的状态变为stop状态，并试图停止所有正在执行的线程（如果有if判断则人为的抛出异常）
        //不再处理还在池队列中等待的任务，当然，它会返回那些未执行的任务。返回List<Runnable>,list对象存储的是还未运行的任务，也就是被
        //取消掉的任务。
        //
    }


    /**
     *awaitTermination(10,TimeUnit.SECONDS)的作用就是查看在指定的时间之间，
     * 线程池是否已经停止工作，也就是最多等待多少时间后去判断线程池是否已经停止工作
     * 此方法需要有shutdown（）方法的配合
     **/
    public static void testAwaitTermination(){
        ThreadPoolExecutor executor =new ThreadPoolExecutor(2,99999,99999l,TimeUnit.SECONDS
        ,new LinkedBlockingDeque<Runnable>());
        executor.execute(new MyRunnableP());
        System.out.println("main begin !"+System.currentTimeMillis());
        try {
            //awaitTermination方法具有阻塞性
            System.out.println(executor.awaitTermination(10,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end !"+System.currentTimeMillis());
    }

    /**
     *
     **/
    public static void testAwaitTerminationShutDown(){
        ThreadPoolExecutor executor =new ThreadPoolExecutor(2,99999,99999l,TimeUnit.SECONDS
                ,new LinkedBlockingDeque<Runnable>());
        executor.execute(new MyRunnableP());
        executor.shutdown();//
        System.out.println("main begin !"+System.currentTimeMillis());
        try {
            //awaitTermination方法具有阻塞性 如果池中有任务在被执行时，则调用awaitTermination
            //出现阻塞，等待指定的时间，如果没有任务时则不再阻塞。
            System.out.println(executor.awaitTermination(1,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end !"+System.currentTimeMillis());
    }

    public static void testException(){

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,9999,99999l,TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        poolExecutor.setThreadFactory(new MyThreadFactoryExeception());
        poolExecutor.execute(new MyRunnableP());
    }
}
