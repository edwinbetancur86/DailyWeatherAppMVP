package com.example.edwinb.agiletrailblazers.ZipCodeMVP;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.edwinb.agiletrailblazers.Configuration.DataFacade;
import com.example.edwinb.agiletrailblazers.Configuration.ServiceListener;
import com.example.edwinb.agiletrailblazers.CustomExceptions.ConnectionUnavailableException;
import com.example.edwinb.agiletrailblazers.DisplayWeatherActivity;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;
import com.google.gson.Gson;

public class ApiZipCodeRepo implements ZipCodeRepo, ServiceListener {

    private static final String TAG = "ApiZipCodeRepo";
    private final String ERROR_WRONG_FORMAT = "There was an error processing your entry" +
            "\nPlease try again" +
            "\nYour entry should be in this format: 02861(zipcode),us(country)";
    private final String ERROR_PROCESSING_WEATHER = "Unexpected error processing weather response";
    private Context context;

    @Override
    public void getWeather(Context con, String zipAndCountryCode, String apiKey, DataFacade dataFacade) {
        try {
            context = con;
            dataFacade.getTheWeatherSum(zipAndCountryCode, apiKey, this, true);
        } catch (ConnectionUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleResponse(Object response) {
        try {
            if (response != null)
                processResponse(((TheWeather) response));
            else
                Toast.makeText(context, ERROR_WRONG_FORMAT, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            // Catch errors attempting to parse response and display failure error
            Toast.makeText(context, ERROR_PROCESSING_WEATHER, Toast.LENGTH_LONG).show();
        }
    }

    private void processResponse(TheWeather response) {
        Intent intent = new Intent(context, DisplayWeatherActivity.class);
        intent.putExtra("WEATHER_RESPONSE", new Gson().toJson(response));
        context.startActivity(intent);
    }

}
