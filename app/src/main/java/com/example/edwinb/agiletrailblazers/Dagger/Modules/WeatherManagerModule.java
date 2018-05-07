package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Configuration.WeatherManager;
import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Dagger.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherManagerModule {

    private final String TAG = "WeatherManagerModule";

    @AppScope
    @Provides
    WeatherManager getWeatherManager(Context context)
    {
        return new WeatherManager((App) context);
    }
}
