package com.example.figmamc.activities.activity.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.figmamc.activities.Entity.Membership;
import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.MembershipApi.PhotoApi;
import com.example.figmamc.activities.Services.MembershipApiService;
import com.example.figmamc.activities.Services.PhotoApiService;
import com.example.figmamc.databinding.LentaBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoFragment extends Fragment {
    LentaBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LentaBinding.inflate(inflater);
        PhotoApiService.getInstance().getPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                Log.d("DEBUG",response.toString());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return binding.getRoot();
    }


}
