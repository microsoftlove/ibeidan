package com.ibeidan.web.proxy;

import com.ibeidan.web.service.impl.OrderServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author lee
 * @DATE 2019/5/20 10:43
 */
public class MyProxyInstance {




    public static Object getProxyInstance(Class clazz){
        ClassLoader classLoader =  MyProxyInstance.class.getClassLoader();
        Class[] clazzs = new Class[]{clazz};
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Object o = Proxy.newProxyInstance(classLoader,clazzs,new MyInvocationHandler());
        return  o;

    }

    public static Object getProxyInstance2(Class clazz){
        ClassLoader classLoader =  MyProxyInstance.class.getClassLoader();
        Class[] clazzs = new Class[]{clazz};
        Object i = Proxy.newProxyInstance(classLoader,clazzs,new MyInvocationHandler(new OrderServiceImpl()));
        return i;

    }
}
