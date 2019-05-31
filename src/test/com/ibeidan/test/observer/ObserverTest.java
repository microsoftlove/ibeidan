package com.ibeidan.test.observer;


import com.ibeidan.web.observe.CurrentConditionsDisplay;
import com.ibeidan.web.observe.StatiscsDisplay;
import com.ibeidan.web.observe.WeatherDataSubject;
import org.junit.Test;

/**
 * @author lee
 * @DATE 2019/3/4 19:30
 */
public class ObserverTest {

    @Test
    public void disTest(){

        WeatherDataSubject weatherDataSubject = new WeatherDataSubject();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataSubject);
        StatiscsDisplay statiscsDisplay = new StatiscsDisplay(weatherDataSubject);
        weatherDataSubject.setMeasurements(80,89,30.4f);
        weatherDataSubject.setMeasurements(40,20,30);
    }
}
