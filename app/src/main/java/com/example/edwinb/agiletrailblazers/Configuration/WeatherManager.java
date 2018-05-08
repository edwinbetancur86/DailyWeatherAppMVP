package com.example.edwinb.agiletrailblazers.Configuration;

import com.example.edwinb.agiletrailblazers.CustomExceptions.ConnectionUnavailableException;
import com.example.edwinb.agiletrailblazers.Dagger.App;

import javax.inject.Inject;

public class WeatherManager extends DataManager {

    @Inject
    protected TheWeatherDao weatherDao;

    public WeatherManager(App app) {
        super(app);
        app.getComponent().inject(this);
    }

    public void getWeather(final String zipAndCountryCode, final String apiKey,
                           final ServiceListener listener, boolean forceServiceCall) throws ConnectionUnavailableException {
        if (forceServiceCall) {
            ServiceListener aListener = createListener(listener);
            weatherDao.retrieveWeather(zipAndCountryCode, apiKey, aListener);
        }
    }
}
