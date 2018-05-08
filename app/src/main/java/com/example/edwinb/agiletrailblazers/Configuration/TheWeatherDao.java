package com.example.edwinb.agiletrailblazers.Configuration;

import android.content.Context;
import com.example.edwinb.agiletrailblazers.API.Api;
import com.example.edwinb.agiletrailblazers.CustomExceptions.ConnectionUnavailableException;
import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;

public class TheWeatherDao extends BaseDao {

    protected Context context;

    public TheWeatherDao(App app) {
        super(app);
    }

    public void retrieveWeather(String zipAndCountryCode, String apiKey, final ServiceListener listener) throws ConnectionUnavailableException {
        Gson gson = buildGson();
        Api api = buildApi(gson);
        Observable observable = api.getWeatherResponse(zipAndCountryCode, apiKey);
        registerObservable(observable, listener);
    }

    /**
     * Create json object with type adapters for deserializing values from json which can be either an object or a list in the
     * json.
     *
     * @return
     */
    private Gson buildGson() {
        return new GsonBuilder().create();
    }
}
