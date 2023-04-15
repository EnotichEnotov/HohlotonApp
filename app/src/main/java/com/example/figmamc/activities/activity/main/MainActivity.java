package com.example.figmamc.activities.activity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.Services.PhotoApiService;
import com.example.figmamc.activities.activity.Fragment.PhotoFragment;
import com.example.figmamc.activities.activity.Fragment.ProfileFragment;
import com.example.figmamc.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PhotoApiService.getInstance().getPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                Log.d("DEBUG",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.d("RBBEB","SFSDF");
                Log.d("RBBEB",t.toString());
                t.printStackTrace();
            }
        });
        binding.pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        binding.pager.setCurrentItem(1);
        binding.mainMenuIconButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.pager.setCurrentItem(0);
            }
        });
        binding.mainMenuIconButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.pager.setCurrentItem(1);
            }
        });
        binding.mainMenuIconButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.pager.setCurrentItem(2);
            }
        });
        binding.mainMenuIconButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.pager.setCurrentItem(3);
            }
        });
    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position%4) {
                case 0:
                    return new PhotoFragment();
                case 1:
                    return new ProfileFragment();
                case 2:
                    return new ProfileFragment();
                case 3:
                    return new ProfileFragment();
                default:
                    return new ProfileFragment();
            }
        }
    }
}