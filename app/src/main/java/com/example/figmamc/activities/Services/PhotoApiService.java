package com.example.figmamc.activities.Services;

import com.example.figmamc.activities.Api.PhotoApi;

public class PhotoApiService {
    private static PhotoApi photoApi;

    private static PhotoApi create(){
        return RetrofitService.getInstance().create(PhotoApi.class);
    }
    public static PhotoApi getInstance(){
        if(photoApi==null) photoApi= create();
        return photoApi;
    }
}
