package com.example.edwinb.agiletrailblazers.WeatherDisplayMVP;

import android.support.annotation.Nullable;
import android.util.Log;

public class DisplayWeatherActivityPresenter implements DisplayWeatherActivityMVP.Presenter{

    @Nullable
    private DisplayWeatherActivityMVP.View view;
    private DisplayWeatherActivityMVP.Model model;

    public DisplayWeatherActivityPresenter(DisplayWeatherActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(DisplayWeatherActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void displayWeather(HandleTheWeatherStatusResponse handleTheWeatherStatusResponse) {
        if (view != null) {
            if (view.getWindSpeed() != null
                    || view.getTemp() != null
                    || view.getSunrise() != null
                    || view.getCloudiness() != null
                    || view.getCurrentCon() != null
                    || view.getDes() != null
                    || view.getHumidity() != null
                    || view.getPressure() != null) {
                model.createWeatherResponse(view.getWindSpeed(),
                        view.getCurrentCon(), view.getTemp(),
                        view.getDes(), view.getCloudiness(),
                        view.getPressure(), view.getHumidity(),
                        view.getSunrise(), handleTheWeatherStatusResponse);
                Log.d("Presenter", "Inside presenter");
            }
            else
                view.showProcessingError();
        }
    }

}
