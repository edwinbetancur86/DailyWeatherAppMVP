package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import com.example.edwinb.agiletrailblazers.Dagger.AppScope;
import com.example.edwinb.agiletrailblazers.Util.NetworkUtility;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkUtilityModule {

    @AppScope
    @Provides
    public NetworkUtility getNetworkUtility() {
        return new NetworkUtility();
    }

}
