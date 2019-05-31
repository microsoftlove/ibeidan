package com.ibeidan.test.jdkproxy;

import com.ibeidan.util.ProxyUtil;
import com.ibeidan.web.proxy.MyProxyInstance;
import com.ibeidan.web.service.OrderService;
import com.ibeidan.web.service.impl.OrderServiceImpl;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @author lee
 * @DATE 2019/5/20 10:40
 */
public class TestJdkProxy {



    @Test
    public void testJdk(){
       // OrderService orderService = new OrderServiceImpl();

       OrderService orderService1 = (OrderService) MyProxyInstance.getProxyInstance2(OrderService.class);
       orderService1.queryOrderById(12l);
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", OrderServiceImpl.class.getInterfaces());

        orderService1.queryOrderById2(12l);
       // System.out.println(orderService1.getOrder(13l).toString());

        String path = "/Users/lee/Downloads/OrderService1.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }

    @Test
    public void testCreate(){
        OrderService orderService = new OrderServiceImpl();
        try {
            System.out.println(            Thread.currentThread().getContextClassLoader().getResource(""));

            OrderService proxyInstance = (OrderService) ProxyUtil.newProxyInstance(orderService);
            proxyInstance.queryOrderById(12l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
