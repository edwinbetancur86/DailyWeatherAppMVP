package com.example.edwinb.agiletrailblazers.ZipCodeMVP;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Configuration.DataFacade;
import com.example.edwinb.agiletrailblazers.Configuration.ServiceListener;

public interface ZipCodeRepo {

    void getWeather(Context context, String zipAndCountryCode, String apiKey, DataFacade dataFacade);
}
