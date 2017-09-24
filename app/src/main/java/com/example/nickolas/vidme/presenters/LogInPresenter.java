package com.example.nickolas.vidme.presenters;

import com.example.nickolas.vidme.model.remote.ILogInDataSource;
import com.example.nickolas.vidme.utils.rx.RxErrorAction;
import com.example.nickolas.vidme.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vidme.views.LogInView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Nickolas on 23.09.2017.
 */

public class LogInPresenter extends BasePresenter<LogInView> {

    private final ILogInDataSource logInDataSource;

    public LogInPresenter(ILogInDataSource logInDataSource) {
        this.logInDataSource = logInDataSource;
    }

    public void createAuth(String userName, String password) {
        subscribe(logInDataSource.createAuth(userName, password)
                .retryWhen(new RxRetryWithDelay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::createAuth, new RxErrorAction(getView().getContext()))
        );
    }
}
