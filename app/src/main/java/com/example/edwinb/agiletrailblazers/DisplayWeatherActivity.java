package com.example.edwinb.agiletrailblazers;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Model.Clouds;
import com.example.edwinb.agiletrailblazers.Model.Main;
import com.example.edwinb.agiletrailblazers.Model.Sys;
import com.example.edwinb.agiletrailblazers.Model.TheWeather;
import com.example.edwinb.agiletrailblazers.Model.Wind;
import com.example.edwinb.agiletrailblazers.WeatherDisplayMVP.DisplayWeatherActivityMVP;
import com.example.edwinb.agiletrailblazers.WeatherDisplayMVP.HandleTheWeatherStatusResponse;
import com.google.gson.Gson;

import javax.inject.Inject;

public class DisplayWeatherActivity extends MotherActivity
        implements NavigationView.OnNavigationItemSelectedListener, DisplayWeatherActivityMVP.View, HandleTheWeatherStatusResponse{

    private static final String TAG = "DisplayWeatherActivity";
    @Inject DisplayWeatherActivityMVP.Presenter presenter;
    private TheWeather theWeatherResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);
        ((App) getApplication()).getComponent().inject(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String weatherResponseJson = getIntent().getStringExtra("WEATHER_RESPONSE");
        theWeatherResponse = new Gson().fromJson(weatherResponseJson, TheWeather.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        // Start the logic to display all of the weather information for each view
        presenter.displayWeather(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showProcessingError() {
        Toast.makeText(this, "There was an error retrieving the information", Toast.LENGTH_LONG).show();
    }

    @Override
    public Wind getWindSpeed() {
        return theWeatherResponse.getWind();
    }

    @Override
    public TheWeather getCurrentCon() {
        return theWeatherResponse;
    }

    @Override
    public Main getTemp() {
        return theWeatherResponse.getMain();
    }

    @Override
    public TheWeather getDes() {
        return theWeatherResponse;
    }

    @Override
    public Clouds getCloudiness() {
        return theWeatherResponse.getClouds();
    }

    @Override
    public Main getPressure() {
        return theWeatherResponse.getMain();
    }

    @Override
    public Main getHumidity() {
        return theWeatherResponse.getMain();
    }

    @Override
    public Sys getSunrise() {return theWeatherResponse.getSys();}

    @Override
    public Sys getCounty() {return theWeatherResponse.getSys();}

    @Override
    public TheWeather getCity() {return theWeatherResponse;}

    @Override
    public void handleWeatherResponse(Wind windSpeed, TheWeather currentCon, Main temp,
                                      TheWeather des, Clouds cloudiness, Main pressure,
                                      Main humidity, Sys sunrise, Sys country, TheWeather city) {
        ((TextView) findViewById(R.id.currentCondition)).setText(String.valueOf(currentCon.getWeather().get(0).getMain()));
        ((TextView) findViewById(R.id.currentDescription)).setText(String.valueOf(des.getWeather().get(0).getDescription()));
        ((TextView) findViewById(R.id.currentTemp)).setText(String.valueOf(motherUtil.convertCalvinToFahrenheit(temp.getTemp())));
        ((TextView) findViewById(R.id.windSpeedResult)).setText(String.valueOf(windSpeed.getSpeed() + " m/s"));
        ((TextView) findViewById(R.id.cloudinessResult)).setText(String.valueOf(cloudiness.getAll()));
        ((TextView) findViewById(R.id.pressureResult)).setText(String.valueOf(pressure.getPressure() + " hpa"));
        ((TextView) findViewById(R.id.humidityResult)).setText(String.valueOf(humidity.getHumidity() + "%"));
        ((TextView) findViewById(R.id.sunriseResult)).setText(String.valueOf(sunrise.getSunrise()));
        ((TextView) findViewById(R.id.measuredCityResult)).setText(String.valueOf(city.getName() + ","));
        ((TextView) findViewById(R.id.measuredCountryResult)).setText(String.valueOf(country.getCountry()));
    }
}
