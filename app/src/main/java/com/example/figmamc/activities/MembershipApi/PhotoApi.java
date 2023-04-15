package com.example.figmamc.activities.MembershipApi;

import com.example.figmamc.activities.Entity.Membership;
import com.example.figmamc.activities.Entity.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoApi {
    @GET("/photo")
    Call<List<Photo>> getPhotos();
}
