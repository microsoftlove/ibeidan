package com.ibeidan.web.bridge.v2;

/**
 * @author lee
 * @DATE 2019/3/13 11:32
 */
public class HouseCorp2 extends Corp2 {

    public HouseCorp2(House house) {
        super(house);
    }


    public void makeMoney(){
        super.makeMoney();
        System.out.println("------------房地产公司赚大钱了-------------");
    }
}
