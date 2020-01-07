package com.ibeidan.util;

/**
 * @author lee
 * @DATE 2020/1/7 17:20
 */
public class ThreadUtil {

    public static void outThreadName(String msg){
        System.out.println(Thread.currentThread().getName()+" "+msg+" " +System.currentTimeMillis());
    }
}
