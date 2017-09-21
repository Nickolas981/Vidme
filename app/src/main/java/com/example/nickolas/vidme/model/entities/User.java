package com.example.nickolas.vidme.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nickolas on 20.09.2017.
 */
public class User {

    @SerializedName("status")
    @Expose(serialize = false, deserialize = false)
//    @Optional
    private Boolean status;
    @SerializedName("auth")
    @Expose(serialize = false, deserialize = false)
    private Auth auth;
    @SerializedName("user")
    @Expose(serialize = false, deserialize = false)
    private User_ user;

    @SerializedName("code")
    @Expose(serialize = false, deserialize = false)
    private String code;

    @SerializedName("error")
    @Expose(serialize = false, deserialize = false)
    private String error;

    public String getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }

}