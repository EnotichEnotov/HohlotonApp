package com.example.figmamc.activities.activity.main;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.Services.PhotoApiService;
import com.example.figmamc.activities.activity.CameraActivity;
import com.example.figmamc.activities.activity.Fragment.ClubsFragment;
import com.example.figmamc.activities.activity.Fragment.PhotoBattlesFragment;
import com.example.figmamc.activities.activity.Fragment.PhotoFragment;
import com.example.figmamc.activities.activity.Fragment.ProfileFragment;
import com.example.figmamc.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.figmamc.R;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.mainMenuIconButton1.setAlpha(0.2f);
        binding.mainMenuIconButton2.setAlpha(0.2f);
        binding.mainMenuIconButton3.setAlpha(0.2f);
        binding.mainMenuIconButton4.setAlpha(0.2f);
        binding.mainMenuIconButton5.setAlpha(1f);

        binding.mainTextIconButton1.setTextColor(getResources().getColor(R.color.grey));
        binding.mainTextIconButton2.setTextColor(getResources().getColor(R.color.grey));
        binding.mainTextIconButton3.setTextColor(getResources().getColor(R.color.grey));
        binding.mainTextIconButton4.setTextColor(getResources().getColor(R.color.grey));
        binding.mainTextIconButton5.setTextColor(getResources().getColor(R.color.black));
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
                binding.mainMenuIconButton1.setAlpha(1f);
                binding.mainMenuIconButton2.setAlpha(0.2f);
                binding.mainMenuIconButton3.setAlpha(0.2f);
                binding.mainMenuIconButton4.setAlpha(0.2f);
                binding.mainMenuIconButton5.setAlpha(0.2f);
                binding.mainTextIconButton1.setTextColor(getResources().getColor(R.color.black));
                binding.mainTextIconButton2.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton3.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton4.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton5.setTextColor(getResources().getColor(R.color.grey));
                binding.pager.setCurrentItem(0);
            }
        });
        binding.mainMenuIconButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainMenuIconButton1.setAlpha(0.2f);
                binding.mainMenuIconButton2.setAlpha(1f);
                binding.mainMenuIconButton3.setAlpha(0.2f);
                binding.mainMenuIconButton4.setAlpha(0.2f);
                binding.mainMenuIconButton5.setAlpha(0.2f);
                binding.mainTextIconButton1.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton2.setTextColor(getResources().getColor(R.color.black));
                binding.mainTextIconButton3.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton4.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton5.setTextColor(getResources().getColor(R.color.grey));
                binding.pager.setCurrentItem(1);
            }
        });
        binding.mainMenuIconButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainMenuIconButton1.setAlpha(0.2f);
                binding.mainMenuIconButton2.setAlpha(0.2f);
                binding.mainMenuIconButton3.setAlpha(0.2f);
                binding.mainMenuIconButton4.setAlpha(1f);
                binding.mainMenuIconButton5.setAlpha(0.2f);
                binding.mainTextIconButton1.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton2.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton3.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton4.setTextColor(getResources().getColor(R.color.black));
                binding.mainTextIconButton5.setTextColor(getResources().getColor(R.color.grey));
                binding.pager.setCurrentItem(2);
            }
        });
        binding.mainMenuIconButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainMenuIconButton1.setAlpha(0.2f);
                binding.mainMenuIconButton2.setAlpha(0.2f);
                binding.mainMenuIconButton3.setAlpha(0.2f);
                binding.mainMenuIconButton4.setAlpha(0.2f);
                binding.mainMenuIconButton5.setAlpha(1f);
                binding.mainTextIconButton1.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton2.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton3.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton4.setTextColor(getResources().getColor(R.color.grey));
                binding.mainTextIconButton5.setTextColor(getResources().getColor(R.color.black));
                binding.pager.setCurrentItem(3);
            }
        });
        binding.adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
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
            View myButton1 = findViewById(R.id.main_menu_icon_button_1);
            View myButton2 = findViewById(R.id.main_menu_icon_button_2);
            View myButton3 = findViewById(R.id.main_menu_icon_button_3);
            View myButton4 = findViewById(R.id.main_menu_icon_button_4);
            View myButton5 = findViewById(R.id.main_menu_icon_button_5);
            switch (position%4) {
                case 0:
                    return new PhotoFragment();
                case 1:
                    return new ClubsFragment();
                case 2:
                    return new PhotoBattlesFragment();
                case 3:
                    return new ProfileFragment();
                default:
                    return new ProfileFragment();
            }
        }
    }
}