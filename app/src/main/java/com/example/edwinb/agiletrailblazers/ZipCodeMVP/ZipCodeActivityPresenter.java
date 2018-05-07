package com.example.edwinb.agiletrailblazers.ZipCodeMVP;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.edwinb.agiletrailblazers.Configuration.DataFacade;
import com.example.edwinb.agiletrailblazers.Configuration.ServiceListener;

public class ZipCodeActivityPresenter implements ZipCodeActivityMVP.Presenter {

    @Nullable
    private ZipCodeActivityMVP.View view;
    private ZipCodeActivityMVP.Model model;
    private final String ERROR_EMPTY_TEXT_MESSAGE = "Zipcode or Country code cannot be empty";

    public ZipCodeActivityPresenter(ZipCodeActivityMVP.Model model) {
        this.model = model;

    }

    @Override
    public void setView(ZipCodeActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void showWeatherButtonClicked(Context context,DataFacade dataFacade) {
        if (view != null)
        {
            if (view.getZipAndCountryCode().trim().equals(""))
                view.showInputError(ERROR_EMPTY_TEXT_MESSAGE);
            else
                model.createWeatherResponse(context, view.getZipAndCountryCode(), view.getApiKey(), dataFacade);

        }
    }
}
