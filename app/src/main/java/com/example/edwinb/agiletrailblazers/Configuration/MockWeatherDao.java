package com.example.edwinb.agiletrailblazers.Configuration;

import com.example.edwinb.agiletrailblazers.BuildConfig;
import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;

public class MockWeatherDao extends TheWeatherDao {


    public MockWeatherDao(App context) {
        super(context);
    }

    @Override
    protected Object responseHook(Object response) {
        response = super.responseHook(response);
        if (BuildConfig.MOCK_WEATHER_FAILURE_ZIPCODE) {
            TheWeather weather = (TheWeather) response;
            weather.setCod(404);
            return weather;
        } else {
            return response;
        }
    }

}
