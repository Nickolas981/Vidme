package com.example.nickolas.vidme.api;

import com.example.nickolas.vidme.model.entities.User;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface VidmeApi {
    @POST("/auth/create")
    Observable<User> createAuth(@Query("username") String username, @Query("password") String password);

    @POST("/auth/delete")
    Observable<Boolean> deleteAuth(@Query("AccessToken") String token);

    @GET("/videos/featured")
    Observable<ResponseBody> featuredVideo(@Query("limit") int limit, @Query("offset") int offset);

    @GET("/videos/new")
    Observable<ResponseBody> newVideo(@Query("limit") int limit, @Query("offset") int offset);

    @GET("/videos/feed")
    Observable<ResponseBody> feedVideo(@Query("limit") int limit, @Query("offset") int offset, @Query("token") String token);
}
