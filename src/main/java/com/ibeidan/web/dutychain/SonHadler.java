package com.ibeidan.web.dutychain;

/**
 * @author lee
 * @DATE 2019/5/21 16:50
 */
public class SonHadler extends Handler {

    public SonHadler() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------母亲向儿子请示-----------");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是：同意");
    }
}
