package com.ibeidan.web.observe;

/**
 * @author lee
 * @DATE 2019/3/4 18:47
 * 被观察者
 * 管理观察者并通知观察者
 */
public interface WeatherSubject {

    public void registerObserver(ObserverWeather o);
    public void removeObserver(ObserverWeather o);
    public void notifyObservers();

}
