package com.example.edwinb.agiletrailblazers.Util;

public class MotherUtility {

    public int convertCalvinToFahrenheit(double degreesKelvin) {
        double celsius = degreesKelvin - 273.0;
        return  (int) ((celsius * 9.0/5.0) + 32.0);
    }

}
