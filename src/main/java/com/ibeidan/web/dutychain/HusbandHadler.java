package com.ibeidan.web.dutychain;

/**
 * @author lee
 * @DATE 2019/5/21 16:50
 */
public class HusbandHadler extends Handler {

    public HusbandHadler() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-----------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是：同意");
    }
}
