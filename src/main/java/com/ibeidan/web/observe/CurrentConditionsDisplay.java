package com.ibeidan.web.observe;

/**
 * @author lee
 * @DATE 2019/3/4 19:17
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
