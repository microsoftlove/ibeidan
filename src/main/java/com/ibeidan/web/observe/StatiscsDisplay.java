package com.ibeidan.web.observe;

/**
 * @author lee
 * @DATE 2019/3/4 19:50
 */
public class StatiscsDisplay implements ObserverWeather,DisplayElement {

    private float temp;

    private float humidity;

    private WeatherSubject weatherSubject;

    public StatiscsDisplay(WeatherSubject weatherSubject) {
        this.weatherSubject = weatherSubject;
        weatherSubject.registerObserver(this);
    }






    @Override
    public void display() {
        System.out.println("AVG/Max/Min:"+temp+"/"+humidity+"/");

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
