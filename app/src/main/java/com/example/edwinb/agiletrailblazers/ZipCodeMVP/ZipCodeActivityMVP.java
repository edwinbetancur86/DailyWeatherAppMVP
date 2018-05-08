package com.example.edwinb.agiletrailblazers.ZipCodeMVP;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Configuration.DataFacade;

public interface ZipCodeActivityMVP {

    interface View {
        String getZipAndCountryCode();
        String getApiKey();

        void showInputError(String errorMessage);
    }

    interface Presenter {
        void setView(ZipCodeActivityMVP.View view);
        void showWeatherButtonClicked(Context context, DataFacade dataFacade);
    }

    interface Model {
        void createWeatherResponse(Context con, String zipAndCountryCode, String apiKey, DataFacade dataFacade);
    }

}
