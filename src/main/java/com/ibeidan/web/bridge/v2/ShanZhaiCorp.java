package com.ibeidan.web.bridge.v2;



/**
 * @author lee
 * @DATE 2019/3/13 11:33
 */
public class ShanZhaiCorp extends Corp2 {

    public ShanZhaiCorp(Product product) {
        super(product);
    }


    public void makeMoney(){
        super.makeMoney();
        System.out.println("------------山寨公司赚大钱了-------------");
    }
}
