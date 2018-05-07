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

    /**
     * Get the history information associated with the user's groupKey and pin.
     * @param zipAndCountryCode
     * @param listener
     * @throws ConnectionUnavailableException
     */
    public void getWeather(final String zipAndCountryCode, final String apiKey, final ServiceListener listener) throws ConnectionUnavailableException
    {
        getWeather(zipAndCountryCode, apiKey, listener, false);
    }

    /*public void getWeather(final String zipCode, final String countryCode, final ServiceListener listener, boolean forceServiceCall) throws ConnectionUnavailableException
    {
        //final CacheFile file = cacheManager.getNewFile(Weather, zipCode + "_" + countryCode);
        if (forceServiceCall) {
            if (file.exists()) {
                cacheManager.deleteFileFromCache(file);
            }
            ServiceListener cacheingListener = createSaveToCacheListener(file, listener);
            weatherDao.retrieveWeather(zipCode, countryCode, cacheingListener);
        } else {
            if (file.exists()) {
                Object cachedResponse = cacheManager.readFromCache(file);
                listener.handleResponse(cachedResponse);
            } else {
                ServiceListener cacheingListener = createSaveToCacheListener(file, listener);
                weatherDao.retrieveWeather(zipCode, countryCode, cacheingListener);
            }
        }
    }*/


    public void getWeather(final String zipAndCountryCode, final String apiKey, final ServiceListener listener, boolean forceServiceCall) throws ConnectionUnavailableException
    {
        if (forceServiceCall) {
            ServiceListener aListener = createListener(listener);
            weatherDao.retrieveWeather(zipAndCountryCode, apiKey, aListener);
        }
    }
}
