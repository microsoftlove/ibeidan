package com.ibeidan.web.dutychain;

/**
 * @author lee
 * @DATE 2019/5/21 16:50
 */
public class FatherHadler extends Handler {

    public FatherHadler() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------女儿向父亲请示-----------");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是：同意");
    }
}
