package com.example.edwinb.agiletrailblazers.Configuration;

import android.content.Context;
import android.util.Log;

import com.example.edwinb.agiletrailblazers.API.Api;
import com.example.edwinb.agiletrailblazers.CustomExceptions.ConnectionUnavailableException;
import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Util.NetworkUtility;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class BaseDao {

    private final String TAG = "BaseDao";
    protected Context context;

    public BaseDao(App app) {
        this.context = app;
        app.getComponent().inject(this);
    }

    protected Api buildApi(Gson gson) {
        return buildApi(gson, Api.BASE_URL);
    }

    protected Api buildApi(Gson gson, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Api.class);
    }

    protected void registerObservable(Observable observable, final ServiceListener listener) throws ConnectionUnavailableException {
        if (NetworkUtility.hasActiveInternetConnection(context)) {
            Observer observer = new ServiceObserver(listener);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
        else
            throw new ConnectionUnavailableException("Unable to establish network connection.");
    }

    private class ServiceObserver implements Observer {
        private ServiceListener listener;
        private ServiceObserver(ServiceListener listener) {
            this.listener = listener;
        }
        @Override
        public void onNext(Object response) {
            Log.d(TAG, "Service success");
            response = responseHook(response);
            listener.handleResponse(response);
        }
        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "Service failure", e);
            listener.handleResponse(null);
        }
        @Override public void onSubscribe(Disposable d) { }
        @Override public void onComplete() { }
    }

    protected Object responseHook(Object response) {
        return response;
    }

}
