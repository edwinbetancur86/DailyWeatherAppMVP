package com.example.edwinb.agiletrailblazers.WeatherDisplayMVP;

import com.example.edwinb.agiletrailblazers.Model.Clouds;
import com.example.edwinb.agiletrailblazers.Model.Main;
import com.example.edwinb.agiletrailblazers.Model.Sys;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;
import com.example.edwinb.agiletrailblazers.Model.Wind;

public interface DisplayWeatherRepo {
    void getWeatherResponse(Wind windSpeed, TheWeather currentCon, Main temp, TheWeather des,
                            Clouds cloudiness, Main pressure, Main humidity, Sys sunrise,
                            HandleTheWeatherStatusResponse handleTheWeatherStatusResponse);
}
