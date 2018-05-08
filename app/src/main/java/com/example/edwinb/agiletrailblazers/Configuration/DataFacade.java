package com.example.edwinb.agiletrailblazers.Configuration;

import com.example.edwinb.agiletrailblazers.CustomExceptions.ConnectionUnavailableException;

public interface DataFacade {
    void getTheWeatherSum(String zipAndCountryCode, String apiKey,
                          ServiceListener listener, boolean forceServiceCall) throws ConnectionUnavailableException;
}
