package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import android.content.Context;
import android.util.Log;

import com.example.edwinb.agiletrailblazers.BuildConfig;
import com.example.edwinb.agiletrailblazers.Configuration.MockWeatherDao;
import com.example.edwinb.agiletrailblazers.Configuration.TheWeatherDao;
import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Dagger.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherDaoModule {

    @AppScope
    @Provides
    TheWeatherDao getWeatherDao(Context context) {
        if (BuildConfig.MOCK_WEATHER_RESPONSE) {
            Log.d("WeatherDaoModule", "Inside true statement of MOCK_WEATHER_RESPONSE");
            return new MockWeatherDao((App) context);
        } else
            return new TheWeatherDao((App) context);
    }
}
