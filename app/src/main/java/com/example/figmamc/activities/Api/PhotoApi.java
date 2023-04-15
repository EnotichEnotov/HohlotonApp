package com.example.figmamc.activities.Api;

import com.example.figmamc.activities.Entity.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PhotoApi {
    @GET("/photo")
    Call<List<Photo>> getPhotos();
    @POST("/photo")
    Photo setPhoto(Photo photo);
}
