package com.example.figmamc.activities.Api;


import com.example.figmamc.activities.Entity.Membership;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MembershipApi {

    @GET("/membership")
    Call<List<Membership>> getMemberships();
}
