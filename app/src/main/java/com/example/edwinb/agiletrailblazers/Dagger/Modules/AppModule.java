package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Dagger.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App application;

    public AppModule(App application) {
        this.application = application;
    }

    @AppScope
    @Provides
    public App provideApp() {
        return application;
    }

    @AppScope
    @Provides
    public Context provideContext() {
        return application;
    }
}
