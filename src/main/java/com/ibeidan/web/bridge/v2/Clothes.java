package com.ibeidan.web.bridge.v2;

/**
 * @author lee
 * @DATE 2019/3/13 11:38
 */
public class Clothes extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出来的衣服是这样的--------");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出来的衣服卖出去了--------");
    }
}
