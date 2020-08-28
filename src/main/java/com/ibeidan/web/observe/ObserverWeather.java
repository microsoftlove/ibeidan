package com.ibeidan.web.observe;

/**
 * @author lee
 * DATE 2019/3/4 18:48
 * 观察者
 * 观察者接收到消息后，即进行更新操作，对接收到的信息进行处理
 */
public interface ObserverWeather {

    public void update(float temp, float humidity, float pressure);
}
