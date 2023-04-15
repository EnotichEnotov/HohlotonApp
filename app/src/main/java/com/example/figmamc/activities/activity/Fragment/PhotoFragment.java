package com.example.figmamc.activities.activity.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.activity.presentation.PhotoViewModel;
import com.example.figmamc.activities.adapter.PhotoAdapter;
import com.example.figmamc.activities.adapter.PhotoClickListener;
import com.example.figmamc.databinding.LentaBinding;

import java.util.ArrayList;
import java.util.List;

public class PhotoFragment extends Fragment {
    LentaBinding binding;
    private PhotoViewModel viewModel;
    private PhotoAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LentaBinding.inflate(inflater);
        viewModel = new ViewModelProvider(this).get(PhotoViewModel.class);
        viewModel.photos.observe(getViewLifecycleOwner(),this::renderPhotos);
        if(savedInstanceState == null) viewModel.load();
        adapter = new PhotoAdapter(new PhotoClickListener() {
            @Override
            public void onClick(long id) {

            }
        });
        //List<Photo> photos = new ArrayList<>();
        binding.posts.setAdapter(adapter);
        //photos.add(new Photo(0,0,
        //        "https://i.imgur.com/kmOj9Xe.png","Bebra"));
        //adapter.setItems(photos);
        return binding.getRoot();
    }
    public void renderPhotos(List<Photo> photos){
        adapter.setItems(photos);
    }

}
