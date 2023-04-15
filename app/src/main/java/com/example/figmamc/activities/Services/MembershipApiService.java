package com.example.figmamc.activities.Services;

import com.example.figmamc.activities.Api.MembershipApi;

public class MembershipApiService {
    private static MembershipApi membershipApi;

    private static MembershipApi create(){
        return RetrofitService.getInstance().create(MembershipApi.class);
    }
    public static MembershipApi getInstance(){
        if(membershipApi==null) membershipApi = create();
        return membershipApi;
    }
}
