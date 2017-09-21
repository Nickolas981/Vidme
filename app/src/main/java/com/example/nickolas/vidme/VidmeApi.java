package com.example.nickolas.vidme;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface VidmeApi {
    @POST("/auth/create")
    Call<User> createAuth(@Query("username") String username, @Query("password") String password);

    @POST("/auth/delete")
    Call<Boolean> deleteAuth(@Query("AccessToken") String token);
}
