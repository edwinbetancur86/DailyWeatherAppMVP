package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import com.example.edwinb.agiletrailblazers.Dagger.AppScope;
import com.example.edwinb.agiletrailblazers.Util.MotherUtility;

import dagger.Module;
import dagger.Provides;

@Module
public class MotherUtilityModule {

    @AppScope
    @Provides
    MotherUtility getMotherUtility()
    {
        return new MotherUtility();
    }
}
