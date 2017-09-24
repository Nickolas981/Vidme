package com.example.nickolas.vidme;

import android.support.multidex.MultiDexApplication;

import com.example.nickolas.vidme.di.component.AppComponent;
import com.example.nickolas.vidme.di.component.DaggerAppComponent;
import com.example.nickolas.vidme.di.module.ApiModule;
import com.example.nickolas.vidme.di.module.AppModule;
import com.example.nickolas.vidme.model.entities.User;


public class App extends MultiDexApplication {

    public static User user;
    private AppComponent appComponent;

    public App() {
        super();

        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }

}
