package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import com.example.edwinb.agiletrailblazers.WeatherDisplayMVP.ApiDisplayWeatherRepo;
import com.example.edwinb.agiletrailblazers.WeatherDisplayMVP.DisplayWeatherActivityMVP;
import com.example.edwinb.agiletrailblazers.WeatherDisplayMVP.DisplayWeatherActivityPresenter;
import com.example.edwinb.agiletrailblazers.WeatherDisplayMVP.DisplayWeatherModel;
import com.example.edwinb.agiletrailblazers.WeatherDisplayMVP.DisplayWeatherRepo;

import dagger.Module;
import dagger.Provides;

@Module
public class DisplayWeatherModule {

    @Provides
    public DisplayWeatherActivityMVP.Presenter providesDisplayWeatherPresenter(DisplayWeatherActivityMVP.Model model) {
        return new DisplayWeatherActivityPresenter(model);
    }

    @Provides
    public DisplayWeatherActivityMVP.Model providesDisplayWeatherModel(DisplayWeatherRepo repo) {
        return new DisplayWeatherModel(repo);
    }

    @Provides
    public DisplayWeatherRepo provideDisplayWeatherRepo(){return new ApiDisplayWeatherRepo();}
}
