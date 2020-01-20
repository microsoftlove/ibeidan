package com.ibeidan.web.dutychain;

/**
 * @author lee
 * @DATE 2019/5/21 16:38
 */
public abstract  class Handler {

    /**
     * 定义处理级别
     **/
    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    private int level = 0 ;

    private Handler nextHandler;//责任传递，下一个责任人是谁

    public Handler(int _level){
        this.level = _level;
    }

    public final void handleMessage(IWomen women){
        if (women.getType() == this.level){
            this.response(women);
        }else {
            if (this.nextHandler != null ){
                this.nextHandler.handleMessage(women);
            }else {
                System.out.println("---没地方请示了，按不同意处理-------");
            }
        }

    }

    /**
     *如果不属于你处理的请求，你应该让她找下一个环节的人，如女儿出嫁了
     *还向父亲请示是否可以逛街，父亲告诉女儿应该请示丈夫
     **/
    public void setNext(Handler _handler){
        this.nextHandler = _handler;
    }

    //有请示当然要回应
    protected abstract void response(IWomen women);


}
