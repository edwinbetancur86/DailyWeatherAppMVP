package com.example.edwinb.agiletrailblazers.Dagger;

import android.app.Application;

import com.example.edwinb.agiletrailblazers.Dagger.Modules.AppModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.DataFacadeModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.DisplayWeatherModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.ZipCodeModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ApplicationComponent getComponent() {
        if (component == null) {
            initComponent();
        }
        return component;
    }

    private void initComponent() {
        component = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .zipCodeModule(new ZipCodeModule())
                .displayWeatherModule(new DisplayWeatherModule())
                .dataFacadeModule(new DataFacadeModule())
                .build();
    }

    public void setComponent(ApplicationComponent component) {
        this.component = component;
    }
}
