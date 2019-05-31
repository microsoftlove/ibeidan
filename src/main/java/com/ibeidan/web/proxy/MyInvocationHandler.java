package com.ibeidan.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lee
 * @DATE 2019/5/20 10:43
 */
public class MyInvocationHandler implements InvocationHandler {

    public  Object target ;

    public MyInvocationHandler() {

    }

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call specific method >>" + method.getName()+"参数==="+args);
        Object o =  method.invoke(target,args);
        System.out.println("after call specific method >>" + method.getName()+"参数==="+args);
        return o;
    }
}
