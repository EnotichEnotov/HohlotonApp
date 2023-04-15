package com.example.figmamc.activities.Api.repository;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.Services.PhotoApiService;

import java.util.List;

import retrofit2.Call;

public class PhotoRepository {
    public static Call<List<Photo>> getPhotos(){
        return PhotoApiService.getInstance().getPhotos();
    }
}
