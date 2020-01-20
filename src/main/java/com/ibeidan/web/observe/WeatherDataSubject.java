package com.ibeidan.web.observe;

import java.util.ArrayList;

/**
 * @author lee
 * @DATE 2019/3/4 18:51
 */
public class WeatherDataSubject implements WeatherSubject{

    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataSubject() {
        this.observers = new ArrayList();
    }



    @Override
    public void registerObserver(ObserverWeather o) {

        observers.add(o);
    }

    @Override
    public void removeObserver(ObserverWeather o) {

    }

    @Override
    public void notifyObservers() {

        for (int i =0; i < observers.size(); i++){
            ObserverWeather observerWeather = (ObserverWeather) observers.get(i);
            observerWeather.update(temperature,humidity,pressure);
        }



    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}
