package com.ibeidan.web.future.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lee
 * DATE 2020/9/1 14:06
 */
public class CompletableFutureService {



    CompletableFuture<String> completableFuture = new CompletableFuture();


    public static void getNow(){
        CompletableFuture<String> cf = CompletableFuture.completedFuture("hello");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }
    public static void thenApply(){
        CompletableFuture<String> cf = CompletableFuture.completedFuture("hello").thenApply(s -> {
            return s.toUpperCase();
        });
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }

    public static void thenApplyAsync(){
        CompletableFuture<String> cf = CompletableFuture.completedFuture("hello").thenApplyAsync(s -> {
            return s.toUpperCase();
        });
        System.out.println(cf.isDone());
        System.out.println(cf.join());
    }

    /**
     * 同步消费
     **/
    static void thenAccept() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept").thenAccept(s -> result.append(s));
        System.out.println(result.toString());
    }

    /**
     * 异步消费
     * join() 方法，它的功能和 get() 方法是一样的，都是阻塞获取值，它们的区别在于 join() 抛出的是 unchecked Exception。
     **/
    static void thenAcceptAsync() {
        StringBuilder result = new StringBuilder();
        CompletableFuture cf =  CompletableFuture.completedFuture("thenAcceptAsync").thenAcceptAsync(s -> result.append(s));

        System.out.println(1);
        System.out.println(cf.isDone());
        System.out.println(2);
        System.out.println(result);
    }

    /**
     *
     **/
    static void twoResultCombine() {

        int x =0;
        int y = 1;
        CompletableFuture cfA =  CompletableFuture.supplyAsync(()->"resultA");
        CompletableFuture cfB = CompletableFuture.supplyAsync(()-> "resultB");

        CompletableFuture d =  cfA.thenCombine(cfB,(resultA,resultB)-> {
            System.out.println(resultA+"==="+resultB);
            return resultA +"  --   "+ resultB;} );
        System.out.println(d.join());

    }

    static void drinkTea(){
        // run()方法没有返回值
        CompletableFuture cf1 = CompletableFuture.runAsync(()->{
            System.out.println("T1:洗水壶……");
            sleepMoment(1,TimeUnit.SECONDS);
            System.out.println("T1:烧开水……");
            sleepMoment(15,TimeUnit.SECONDS);
            System.out.println("T1:水烧开……");
        });
        //get()方法有返回值
        CompletableFuture cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println("T2:洗茶壶……");
            sleepMoment(1,TimeUnit.SECONDS);
            System.out.println("T2:洗茶杯……");
            sleepMoment(2,TimeUnit.SECONDS);

            System.out.println("T2:拿茶叶……");
            sleepMoment(1,TimeUnit.SECONDS);

            return "龙井";
        });

        //q 对应cf1参数， tf对应cf2的参数
        CompletableFuture cf3 = cf1.thenCombine(cf2,(q,tf)->{
            System.out.println(q);
            System.out.println("T1:拿到茶叶："+tf);
            System.out.println("T1:泡茶……");
            return "上茶："+tf;
        });

        System.out.println(cf3.join());
    }

     static String exeA(String msg){
            return msg;
    }

    static void sleepMoment(int t, TimeUnit unit){
        try {
            unit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        getNow();
        thenApply();
        thenApplyAsync();
        thenAccept();
        thenAcceptAsync();
        twoResultCombine();
        drinkTea();
    }

}
