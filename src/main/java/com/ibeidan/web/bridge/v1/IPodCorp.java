package com.ibeidan.web.bridge.v1;

/**
 * IPod山寨公司
 * @author lee
 * @DATE 2019/3/13 11:16
 */
public class IPodCorp extends Corp {
    @Override
    protected void produce() {
        System.out.println("我生产iPod……");
    }

    @Override
    protected void sell() {
        System.out.println("ipod畅销……");
    }

    public void makeMoney(){
        super.makeMoney();
        System.out.println("我赚钱钱了……");
    }
}
