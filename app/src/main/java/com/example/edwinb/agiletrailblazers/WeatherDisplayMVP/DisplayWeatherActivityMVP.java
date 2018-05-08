package com.example.edwinb.agiletrailblazers.WeatherDisplayMVP;

import com.example.edwinb.agiletrailblazers.Model.Clouds;
import com.example.edwinb.agiletrailblazers.Model.Main;
import com.example.edwinb.agiletrailblazers.Model.Sys;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;
import com.example.edwinb.agiletrailblazers.Model.Wind;

public interface DisplayWeatherActivityMVP {

    interface View {
        void showProcessingError();
        Wind getWindSpeed();
        TheWeather getCurrentCon();
        Main getTemp();
        TheWeather getDes();
        Clouds getCloudiness();
        Main getPressure();
        Main getHumidity();
        Sys getSunrise();
    }

    interface Presenter {
        void setView(DisplayWeatherActivityMVP.View view);
        void displayWeather(HandleTheWeatherStatusResponse handleTheWeatherStatusResponse);

    }

    interface Model {
        void createWeatherResponse(Wind windSpeed, TheWeather currentCon, Main temp, TheWeather des,
                                   Clouds cloudiness, Main pressure, Main humidity, Sys sunrise,
                                   HandleTheWeatherStatusResponse handleTheWeatherStatusResponse);
    }
}
