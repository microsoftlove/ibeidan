package com.ibeidan.web.observe;

/**
 * @author lee
 * @DATE 2019/3/4 19:17
 *
 * 具体的观察者
 * 接收到消息后处理反应是不同的，各个观察者有自己的处理逻辑
 *
 */
public class CurrentConditionsDisplay implements ObserverWeather,DisplayElement{
    private float temp;

    private float humidity;

    private WeatherSubject weatherSubject;

    public CurrentConditionsDisplay(WeatherSubject weatherSubject) {
        this.weatherSubject = weatherSubject;
        weatherSubject.registerObserver(this);
    }

    @Override
    public void display() {

        System.out.println("Current conditions:"+temp+"F degrees and "+humidity+"% humidity");

    }

    @Override
    public void update(float temp, float humidity, float pressure) {

        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
