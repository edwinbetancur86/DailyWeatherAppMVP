package com.example.edwinb.agiletrailblazers.Configuration;

import com.example.edwinb.agiletrailblazers.CustomExceptions.ConnectionUnavailableException;
import com.example.edwinb.agiletrailblazers.Dagger.App;

import javax.inject.Inject;

public class DataFacadeImpl implements DataFacade {

    @Inject protected WeatherManager weatherManager;

    public DataFacadeImpl(App app) {
        app.getComponent().inject(this);
    }

    @Override
    public void getTheWeatherSum(String zipAndCountryCode,
                                 String apiKey, ServiceListener listener,
                                 boolean forceServiceCall) throws ConnectionUnavailableException {
        weatherManager.getWeather(zipAndCountryCode, apiKey, listener, forceServiceCall);
    }
}
