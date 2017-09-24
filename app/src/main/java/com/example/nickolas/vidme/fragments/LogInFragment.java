package com.example.nickolas.vidme.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nickolas.vidme.App;
import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.activities.MainActivity;
import com.example.nickolas.vidme.di.component.AppComponent;
import com.example.nickolas.vidme.di.component.DaggerPresentersComponent;
import com.example.nickolas.vidme.di.module.PresentersModule;
import com.example.nickolas.vidme.model.entities.User;
import com.example.nickolas.vidme.presenters.LogInPresenter;
import com.example.nickolas.vidme.views.LogInView;
import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LogInFragment extends Fragment implements LogInView {

    @BindView(R.id.email)
    TextView emailTV;
    @BindView(R.id.pass)
    TextView passTV;

    @BindView(R.id.log_in)
    Button login;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    LogInPresenter presenter;

    public static LogInFragment newInstance() {
        return new LogInFragment();
    }

    public AppComponent getAppComponent() {
        return ((App) getActivity().getApplication()).appComponent();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPresentersComponent.builder()
                .appComponent(getAppComponent())
                .presentersModule(new PresentersModule())
                .build()
                .inject(this);
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater
            , @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_log_in, container, false);

        ButterKnife.bind(this, v);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAuth();
                presenter.createAuth(emailTV.getText().toString(), passTV.getText().toString());
            }
        });
        return v;
    }

    private void startAuth() {
        progressBar.setVisibility(View.VISIBLE);
        login.setVisibility(View.GONE);
    }

    private void fisnishAuth() {
        progressBar.setVisibility(View.GONE);
        login.setVisibility(View.VISIBLE);
    }

    @Override
    public void createAuth(User user) {
        fisnishAuth();
        App.user = user;
        synchronized (MainActivity.adapter){
            MainActivity.adapter.notifyDataSetChanged();
        }
        Gson gson = new Gson();
        String json = gson.toJson(user);
        SharedPreferences sharedPreferences =
                MainActivity.activity.getPreferences(Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("user", json).apply();
        MainActivity.imageButton.setVisibility(View.VISIBLE);
    }
}
