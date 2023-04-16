package com.example.figmamc.activities.Api;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.Entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {
    @GET("/user")
    Call<List<User>> getUsers();
    @GET("/user/{id}")
    User getUser(long id);
    @POST("/user")
    User setUser(User user);
}
