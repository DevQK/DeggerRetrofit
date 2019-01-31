package khanh.deggerretrofit.App;

import android.app.Application;

import khanh.deggerretrofit.API.ApiComponent;
import khanh.deggerretrofit.API.DaggerApiComponent;
import khanh.deggerretrofit.Module.ApiModule;
import khanh.deggerretrofit.Module.AppModule;

public class MyApplication extends Application {
    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApiComponent.builder().apiModule(new ApiModule("https://simplifiedcoding.net/demos/")).appModule(new AppModule(this)).build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
