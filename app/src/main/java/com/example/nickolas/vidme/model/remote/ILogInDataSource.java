package com.example.nickolas.vidme.model.remote;

import com.example.nickolas.vidme.model.entities.User;

import rx.Observable;

/**
 * Created by Nickolas on 23.09.2017.
 */

public interface ILogInDataSource {

    Observable<User> createAuth(String userName, String password);

}
