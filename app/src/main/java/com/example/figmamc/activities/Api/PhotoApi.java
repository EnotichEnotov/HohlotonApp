package com.example.figmamc.activities.Api;

import com.example.figmamc.activities.Entity.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoApi {
    @GET("/photo")
    Call<List<Photo>> getPhotos();
}
