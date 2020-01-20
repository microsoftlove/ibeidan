package com.ibeidan.web.future.exchange;

import java.util.concurrent.Exchanger;

/**
 * @author lee
 *  2020/1/3 15:03
 *线程间通信
 */
public class ExchangeTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadExchange threadExchange = new ThreadExchange(exchanger);
        threadExchange.start();

        ThreadExchangeB b = new ThreadExchangeB(exchanger);
        b.start();

        System.out.println("main end!");
    }



}
