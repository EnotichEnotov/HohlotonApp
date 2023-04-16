package com.example.figmamc.activities.Api.repository;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.Entity.User;
import com.example.figmamc.activities.Services.PhotoApiService;
import com.example.figmamc.activities.Services.UserApiService;

import java.util.List;

import retrofit2.Call;

public class UserRepository {
    public static Call<List<User>> getUsers(){
        return UserApiService.getInstance().getUsers();
    }
    public static User getById(long id){
        return UserApiService.getInstance().getUser(id);
    }
}
