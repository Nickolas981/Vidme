package com.example.nickolas.vidme.model.remote;

import com.example.nickolas.vidme.api.VidmeApi;
import com.example.nickolas.vidme.model.entities.User;

import rx.Observable;

/**
 * Created by Nickolas on 23.09.2017.
 */

public class LogInDataSource implements ILogInDataSource {

    private VidmeApi api;

    public LogInDataSource(VidmeApi api) {
        this.api = api;
    }

    @Override
    public Observable<User> createAuth(String userName, String password) {
        return api.createAuth(userName, password);
    }
}
