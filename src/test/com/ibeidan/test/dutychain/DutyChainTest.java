package com.ibeidan.test.dutychain;

import com.ibeidan.web.dutychain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author lee 责任链模式测试
 * @DATE 2019/5/21 17:03
 */
public class DutyChainTest {

    @Test
    public void testChain(){
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i =0 ;i<5 ;i++){
            arrayList.add(new Women(random.nextInt(4),"我要去逛街"));
        }

        //定义三个请示对象
        Handler father = new FatherHadler();
        Handler husband = new HusbandHadler();
        Handler son = new SonHadler();

        //设置请示顺序
        father.setNext(husband);
        husband.setNext(son);
        for (IWomen w:arrayList) {
            father.handleMessage(w);
        }


    }

}
