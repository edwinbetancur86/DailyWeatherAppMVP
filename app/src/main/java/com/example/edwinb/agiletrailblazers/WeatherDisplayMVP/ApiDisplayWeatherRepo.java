package com.example.edwinb.agiletrailblazers.WeatherDisplayMVP;

import android.util.Log;
import com.example.edwinb.agiletrailblazers.Model.Clouds;
import com.example.edwinb.agiletrailblazers.Model.Main;
import com.example.edwinb.agiletrailblazers.Model.Sys;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;
import com.example.edwinb.agiletrailblazers.Model.Wind;

public class ApiDisplayWeatherRepo implements DisplayWeatherRepo {

    private static final String TAG = "ApiDisplayWeatherRepo";

    @Override
    public void getWeatherResponse(Wind windSpeed, TheWeather currentCon, Main temp, TheWeather des,
                                   Clouds cloudiness, Main pressure, Main humidity, Sys sunrise,
                                   HandleTheWeatherStatusResponse handleTheWeatherStatusResponse) {
        // Handle the weather status from the response
        Log.d(TAG, "Wind speed is: " + String.valueOf(windSpeed.getSpeed()));
        handleTheWeatherStatusResponse.handleWeatherResponse(windSpeed, currentCon, temp, des,
                cloudiness, pressure, humidity, sunrise);
    }
}
