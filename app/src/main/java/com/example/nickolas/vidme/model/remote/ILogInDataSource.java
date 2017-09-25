package com.example.nickolas.vidme.model.remote;

import com.example.nickolas.vidme.model.entities.User;

import rx.Observable;

public interface ILogInDataSource {

    Observable<User> createAuth(String userName, String password);

}
