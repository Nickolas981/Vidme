package com.example.nickolas.vidme.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nickolas.vidme.di.module.ApiModule;
import com.example.nickolas.vidme.di.module.AppModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;




@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class
})
public interface AppComponent extends ApiComponent {

    Context context();

    SharedPreferences preferences();

    Executor executor();

}
