package com.example.edwinb.agiletrailblazers.API;

import com.example.edwinb.agiletrailblazers.BuildConfig;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://" + BuildConfig.SERVICE_SUBDOMAIN;

    //zip={zipCode},{countryCode}&appid={apiKey}
    @GET("data/2.5/weather")
    Observable<TheWeather> getWeatherResponse(@Query("zip") String zipAndCountryCode,
                                              @Query("apiKey") String apiKey);

}
