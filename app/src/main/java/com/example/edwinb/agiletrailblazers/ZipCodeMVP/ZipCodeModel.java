package com.example.edwinb.agiletrailblazers.ZipCodeMVP;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Configuration.DataFacade;

public class ZipCodeModel implements ZipCodeActivityMVP.Model{

    private ZipCodeRepo repository;

    public ZipCodeModel(ZipCodeRepo repository) {
        this.repository = repository;
    }

    @Override
    public void createWeatherResponse(Context con, String zipAndCountryCode, String apiKey, DataFacade dataFacade) {
        repository.getWeather(con, zipAndCountryCode, apiKey, dataFacade);
    }
}
