package com.ibeidan.web.bridge.v1;

/**
 * 房地产公司
 * @author lee
 * @DATE 2019/3/13 10:57
 */
public class HouseCorp extends Corp {

    //房地产公司盖房子
    @Override
    protected void produce() {
        System.out.println("房地产公司盖房子……");
    }

    @Override
    protected void sell() {
        System.out.println("房地产公司出售房子……");
    }

    public void makeMoney(){
        super.makeMoney();
        System.out.println("房地产公司赚大钱了……");
    }
}
