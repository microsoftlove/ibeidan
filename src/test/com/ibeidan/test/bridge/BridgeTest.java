package com.ibeidan.test.bridge;


import com.ibeidan.web.bridge.v1.HouseCorp;
import com.ibeidan.web.bridge.v1.IPodCorp;
import com.ibeidan.web.bridge.v2.*;
import org.junit.Test;

/**
 * @author lee
 * @DATE 2019/3/13 11:03
 */
public class BridgeTest {



    @Test
    public void test(){
        System.out.println("房地产公司是这样运营的……");
        HouseCorp houseCorp = new HouseCorp();
        houseCorp.makeMoney();
        System.out.println("\n");
        //System.out.println("服装公司是这样运营的……");
        //ClothesCorp clothesCorp = new ClothesCorp();
        //clothesCorp.makeMoney();
        System.out.println("山寨公司是这样运营的……");
        IPodCorp iPodCorp =new IPodCorp();
        iPodCorp.makeMoney();

    }


    @Test
    public void test2(){
        System.out.println("--------房地产公司是这样运营的-------");
        House house =new House();
        HouseCorp2 houseCorp2 =new HouseCorp2(house);
        houseCorp2.makeMoney();

        System.out.println("山寨公司是这样运营的--------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();

        ShanZhaiCorp shanZhaiCorp2 = new ShanZhaiCorp(new Clothes());
        shanZhaiCorp2.makeMoney();

    }
}
