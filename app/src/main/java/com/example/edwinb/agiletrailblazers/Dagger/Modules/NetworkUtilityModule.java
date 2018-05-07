package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import android.content.Context;

import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Dagger.AppScope;
import com.example.edwinb.agiletrailblazers.Util.NetworkUtility;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkUtilityModule {

    @AppScope
    @Provides
    public NetworkUtility getNetworkUtility(Context context) {
        return new NetworkUtility((App) context);
    }

}
