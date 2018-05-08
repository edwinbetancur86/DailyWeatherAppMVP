package com.example.edwinb.agiletrailblazers.WeatherDisplayMVP;

import android.util.Log;

import com.example.edwinb.agiletrailblazers.Model.Clouds;
import com.example.edwinb.agiletrailblazers.Model.Main;
import com.example.edwinb.agiletrailblazers.Model.Sys;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;
import com.example.edwinb.agiletrailblazers.Model.Wind;

public class DisplayWeatherModel implements DisplayWeatherActivityMVP.Model {

    private static final String TAG = "DisplayWeatherModel";
    private DisplayWeatherRepo displayWeatherRepo;

    public DisplayWeatherModel(DisplayWeatherRepo repo){this.displayWeatherRepo = repo;}

    @Override
    public void createWeatherResponse(Wind windSpeed, TheWeather currentCon, Main temp, TheWeather des,
                                      Clouds cloudiness, Main pressure, Main humidity, Sys sunrise,
                                      HandleTheWeatherStatusResponse handleTheWeatherStatusResponse) {
        Log.d(TAG, "Inside DisplayWeatherModel just before the getWeatherResponse call");
        displayWeatherRepo.getWeatherResponse
                (windSpeed, currentCon, temp, des, cloudiness, pressure, humidity, sunrise, handleTheWeatherStatusResponse);
    }
}
