package com.example.figmamc.activities.Services;

import com.example.figmamc.activities.Api.MembershipApi;
import com.example.figmamc.activities.Api.UserApi;

public class UserApiService{
    private static UserApi userApi;

    private static UserApi create(){
        return RetrofitService.getInstance().create(UserApi.class);
    }
    public static UserApi getInstance(){
        if(userApi==null) userApi = create();
        return userApi;
    }
}
