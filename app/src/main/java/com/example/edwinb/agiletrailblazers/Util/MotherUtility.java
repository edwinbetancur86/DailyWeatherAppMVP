package com.example.edwinb.agiletrailblazers.Util;

import android.content.Context;

public class MotherUtility {
    private Context context;
    private double celsius;

    public MotherUtility(Context con) {
        context = con;
    }

    public int convertCelvinToFahrenheit(double degreesKelvin)
    {
        celsius = degreesKelvin - 273.0;
        return  (int) ((celsius * 9.0/5.0) + 32.0);
    }

}
