package com.ibeidan.web.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author lee
 * @DATE 2020/4/20 19:26
 */
public class MyApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("自定义 MyApplicationListener ==="+event);
        if (event instanceof ContextClosedEvent){
            System.out.println("自定义 MyApplicationListener 关闭事件==="+event);
        }
        Runtime.getRuntime().addShutdownHook(new MyShotDownThread());

    }
}
