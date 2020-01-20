package com.ibeidan.web.bridge.v2;

/**
 * @author lee
 * @DATE 2019/3/13 11:21
 */
public abstract  class Product {


    //甭管什么产品它总是能被生产出来
    public abstract void beProducted();

    //生产出来的东西，一定要销售出去，否则亏本
    public abstract void beSelled();
}
