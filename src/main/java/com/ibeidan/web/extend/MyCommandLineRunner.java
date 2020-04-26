package com.ibeidan.web.extend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lee
 *  2020/4/20 19:37
 *
 * CommandLineRunner并不是Spring框架原有的概念，
 * 它属于SpringBoot应用特定的回调扩展接口
 *
 * 1.所有CommandLineRunner的执行时间点是在SpringBoot应用的Application完全初始化工作之后
 * (这里我们可以认为是SpringBoot应用启动类main方法执行完成之前的最后一步)。
 *
 * 2.当前SpringBoot应用的ApplicationContext中的所有CommandLinerRunner都会被加载执行
 * (无论是手动注册还是被自动扫描注册到IoC容器中)。
 */
@Order(value = 2)
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("自定义 MyCommandLineRunner ");
    }
}
