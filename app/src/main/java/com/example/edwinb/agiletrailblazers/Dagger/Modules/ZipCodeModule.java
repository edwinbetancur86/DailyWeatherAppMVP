package com.example.edwinb.agiletrailblazers.Dagger.Modules;

import com.example.edwinb.agiletrailblazers.ZipCodeMVP.ApiZipCodeRepo;
import com.example.edwinb.agiletrailblazers.ZipCodeMVP.ZipCodeActivityMVP;
import com.example.edwinb.agiletrailblazers.ZipCodeMVP.ZipCodeActivityPresenter;
import com.example.edwinb.agiletrailblazers.ZipCodeMVP.ZipCodeModel;
import com.example.edwinb.agiletrailblazers.ZipCodeMVP.ZipCodeRepo;

import dagger.Module;
import dagger.Provides;

@Module
public class ZipCodeModule {

    @Provides
    public ZipCodeActivityMVP.Presenter provideZipCodeActivityPresenter(ZipCodeActivityMVP.Model model) {
        return new ZipCodeActivityPresenter(model);
    }


    @Provides
    public ZipCodeActivityMVP.Model provideZipCodeActivityModel(ZipCodeRepo repository) {
        return new ZipCodeModel(repository);
    }

    @Provides
    public ZipCodeRepo provideZipCodeRepository()
    {
        return new ApiZipCodeRepo();
    }

}
