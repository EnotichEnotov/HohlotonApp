package com.example.figmamc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.figmamc.databinding.ActivityMainBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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
                    return new ProfileFragment();
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