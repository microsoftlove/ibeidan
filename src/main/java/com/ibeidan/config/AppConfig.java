package com.ibeidan.config;

import com.ibeidan.web.service.OrderService;
import com.ibeidan.web.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author lee
 * @DATE 2019/6/21 17:17
 */
@Configuration
public class AppConfig {


    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl();
    }
}
