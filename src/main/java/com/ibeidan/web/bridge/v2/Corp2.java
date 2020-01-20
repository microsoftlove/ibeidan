package com.ibeidan.web.bridge.v2;

/**
 * @author lee
 * @DATE 2019/3/13 10:51
 */
public abstract  class Corp2 {

    private Product product;

    public Corp2(Product product){
        this.product = product;
    }



    public void makeMoney(){
        //每个公司都一样，先生产
        this.product.beProducted();
        //然后销售
        this.product.beSelled();
    }

}
