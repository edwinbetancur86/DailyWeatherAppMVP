package com.example.edwinb.agiletrailblazers.Dagger;


import com.example.edwinb.agiletrailblazers.Configuration.BaseDao;
import com.example.edwinb.agiletrailblazers.Configuration.DataFacadeImpl;
import com.example.edwinb.agiletrailblazers.Configuration.DataManager;
import com.example.edwinb.agiletrailblazers.Configuration.WeatherManager;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.AppModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.DataFacadeModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.DisplayWeatherModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.MotherUtilityModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.NetworkUtilityModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.WeatherDaoModule;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.WeatherManagerModule;
import com.example.edwinb.agiletrailblazers.DisplayWeatherActivity;
import com.example.edwinb.agiletrailblazers.MotherActivity;
import com.example.edwinb.agiletrailblazers.Dagger.Modules.ZipCodeModule;
import com.example.edwinb.agiletrailblazers.ZipcodeActivity;

import dagger.Component;

@AppScope
@Component(modules = {
        //All classes being injected should have a module file with a provides method
        AppModule.class,

        WeatherDaoModule.class,

        DataFacadeModule.class,
        WeatherManagerModule.class,

        //CacheManagerModule.class,
        MotherUtilityModule.class,
        NetworkUtilityModule.class,

        ZipCodeModule.class,
        DisplayWeatherModule.class,
})

/**
 *  List all files which will be injected into base classes can be used as an injection point,
 *  but not interfaces, it needs to be the class making the injection call
 *
 *  If a subclass injects a class not injected by the base class, then the subclass must be listed here
 */
public interface ApplicationComponent {

    void inject (MotherActivity target);
    void inject (ZipcodeActivity target);
    void inject (DisplayWeatherActivity target);

    void inject (DataFacadeImpl target);
    void inject (DataManager dataManager);
    void inject (WeatherManager dataManager);
    void inject (BaseDao baseDao);
}
