package com.ibeidan.web.bridge.v2;

/**
 * @author lee
 * @DATE 2019/3/13 11:23
 */
public class IPod extends Product {
    @Override
    public void beProducted() {
        System.out.println("生产出来的IPod是这样的--------");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出来的IPod卖出去了--------");
    }
}
