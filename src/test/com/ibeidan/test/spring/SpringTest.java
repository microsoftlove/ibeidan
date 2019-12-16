package com.ibeidan.test.spring;

import com.ibeidan.config.AppConfig;
import com.ibeidan.web.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author lee
 * @DATE 2019/6/21 17:16
 */
public class SpringTest {


    @Test
    public void annoTest(){

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ctx.getBean(OrderService.class);
        orderService.queryOrderById(999L);
    }



    @Test
    public void xmlTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.queryOrderById(888l);
    }

}
