package com.ibeidan.web.dutychain;

/**
 * @author lee
 * @DATE 2019/5/21 16:57
 */
public class Women implements IWomen {

    /**
     * 1：未出嫁 女儿
     * 2：已出嫁 妻子
     * 3：夫死   母亲
     **/
    private int type = 0;

    private String request = "";

    public Women(int type, String request) {
        this.type = type;
        switch (this.type){
            case 1:
                this.request = "女儿的请求是："+request;
                break;
            case 2:
                this.request = "妻子的请求是："+request;
                break;
            case 3:
                this.request = "母亲的请求是："+request;
                break;
        }
    }

    //获得自己的状况
    @Override
    public int getType() {
        return this.type;
    }

    //获得妇女的请求
    @Override
    public String getRequest() {
        return this.request;
    }

    
}
