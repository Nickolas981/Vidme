package com.example.nickolas.vidme.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nickolas.vidme.App;
import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.model.entities.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LogInFrament extends Fragment {

    TextView emailTV;
    TextView passTV;

    Button login;

    public static LogInFrament newInstance() {
        return new LogInFrament();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_log_in_frament, container, false);

        emailTV = (TextView) v.findViewById(R.id.email);
        passTV = (TextView) v.findViewById(R.id.pass);

        login = (Button) v.findViewById(R.id.log_in);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                App.getVidmeApi().createAuth("nickolasgumeniuk", "a23031998").enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, Response<User> response) {
//                        try {
//                            App.user = response.body();
//                            System.out.println("asdasdasdasdasdasd");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//                        System.out.println("asdasdasdasdasd" + t);
//                    }
//                });


//                App.getVidmeApi().featuredVideo(5).enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        try {
//                            String res = response.body().string();
//                            JSONObject r = new JSONObject(res);
//                            JSONArray ra = r.getJSONArray("videos");
//
//                            System.out.println("sdfdsfdsfds" + ra.toString());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                    }
//                });

//            }
//           App.getVidmeApi().createAuth(emailTV.getText().toString(), passTV.getText().toString(),"Basic bVBjcjZIVUtrU0toYlhVZ21MQ3h6YjJLeG5zOXZKdW06ajZvNTRYTHdjcnFac0NySEZMWHdLS1pKUlpRRVhVWWsxSGxaaUg2UA==")
//                       .enqueue(new Callback<User>() {
//                           @Override
//                           public void onResponse(Call<User> call, Response<User> response) {
//                               App.user = response.body();
//                               Toast.makeText(MainActivity.activity, "Succses"
//                                       + App.user.getAuth().getToken().toString(), Toast.LENGTH_SHORT)
//                                       .show();
//                           }
//
//                           @Override
//                           public void onFailure(Call<User> call, Throwable t) {
//                               Toast.makeText(MainActivity.activity, "Fail", Toast.LENGTH_SHORT).show();
//                           }
//                       });
//        });
        return v;
    }
}
