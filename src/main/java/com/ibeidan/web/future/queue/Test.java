package com.ibeidan.web.future.queue;

/**
 * @author lee
 *  2020/4/20 13:46
 */
public class Test {

    public static void main(String[] args) {
        MyServiceMap serviceMap = new MyServiceMap();
        MyThreadMap1 myThreadMap1 = new MyThreadMap1("one",serviceMap);


        MyThreadMap2 myThreadMap2 = new MyThreadMap2("two",serviceMap);
        myThreadMap1.start();
        myThreadMap2.start();
    }
}
