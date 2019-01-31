package khanh.deggerretrofit.API;

import javax.inject.Singleton;

import dagger.Component;
import khanh.deggerretrofit.MainActivity;
import khanh.deggerretrofit.Module.ApiModule;
import khanh.deggerretrofit.Module.AppModule;

@Singleton
@Component(modules = {ApiModule.class, AppModule.class})
public interface ApiComponent {
    void inJection(MainActivity mainActivity);
}
