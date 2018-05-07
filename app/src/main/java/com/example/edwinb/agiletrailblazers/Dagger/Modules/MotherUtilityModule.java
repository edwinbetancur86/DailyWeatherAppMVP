package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Dagger.AppScope;
import com.example.edwinb.agiletrailblazers.Util.MotherUtility;

import dagger.Module;
import dagger.Provides;

@Module
public class MotherUtilityModule {

    private final String TAG = "MotherUtilityModule";

    @AppScope
    @Provides
    MotherUtility getHistoryManager(Context context)
    {
        return new MotherUtility((App) context);
    }
}
