package com.ibeidan.web.bridge.v1;

/**
 * @author lee
 * @DATE 2019/3/13 10:51
 */
public abstract  class Corp {


    /*
     *如果是公司就应该有生产，不管是软件公司还是制造业公司
     * 每家公司生产的东西都不一样，所以由实现类来完成
     **/
    protected abstract void produce();

    /*
     * 有产品了，那肯定要销售啊，不销售公司怎么生存
     **/
    protected abstract void sell();

    public void makeMoney(){
        //每个公司都一样，先生产
        this.produce();
        //然后销售
        this.sell();
    }
    //猛一看，咋是模版方法模式 请往下看 合适的方法存在合适的类中
}
