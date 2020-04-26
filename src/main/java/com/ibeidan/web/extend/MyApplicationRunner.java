package com.ibeidan.web.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lee
 *  2020/3/19 21:19
 */
@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected static Boolean started = false;

    public static boolean isStarted(){
        return started;
    }
    public static void setStarted(boolean start){
        started = start;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("测试服务MyApplicationRunner");
        // 以下方法并非一定执行,根据版本升级情况决定是否执行,某些数据未产生变动不需执行,此处执行方法目的是为了解决缓存数据一致性问题
        // 同步缓存中的通知消息数目
        started = true;
        logger.info("started==========重启后值为={}",started);
    }
}


