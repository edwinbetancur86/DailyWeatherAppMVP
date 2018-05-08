package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Configuration.DataFacade;
import com.example.edwinb.agiletrailblazers.Configuration.DataFacadeImpl;
import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Dagger.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class DataFacadeModule {

    @AppScope
    @Provides
    public DataFacade getDataFacade(Context context) {
        return new DataFacadeImpl((App) context);
    }
}
