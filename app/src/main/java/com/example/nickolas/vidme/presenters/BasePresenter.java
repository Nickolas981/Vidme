package com.example.nickolas.vidme.presenters;

import com.example.nickolas.vidme.views.BaseView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;




public class BasePresenter<T extends BaseView> {

    private T view;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    public void destroy() {
        compositeSubscription.clear();
    }

    protected Subscription subscribe(Subscription subscription) {
        compositeSubscription.add(subscription);
        return subscription;
    }

}
