package com.ibeidan.web.extend;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lee
 * @DATE 2020/4/20 19:30
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("自定义 MyApplicationContextInitializer initialize方法");
    }
}
