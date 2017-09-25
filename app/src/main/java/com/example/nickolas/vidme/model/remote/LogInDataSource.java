package com.example.nickolas.vidme.model.remote;

import com.example.nickolas.vidme.api.VidmeApi;
import com.example.nickolas.vidme.model.entities.User;

import rx.Observable;

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
