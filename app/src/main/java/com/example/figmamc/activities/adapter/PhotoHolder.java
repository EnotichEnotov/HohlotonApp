package com.example.figmamc.activities.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.databinding.PhotoListBinding;

public class PhotoHolder extends RecyclerView.ViewHolder {
    private PhotoListBinding binding;
    private PhotoClickListener listener;
    public PhotoHolder(PhotoListBinding binding,PhotoClickListener listener) {
        super(binding.getRoot());
        this.binding=binding;
        this.listener=listener;
    }
    public void bind(Photo item){
        binding.postText.setText(item.getPhotoText());
        Glide.with(binding.getRoot()).load(item.getPhotoUrl()).into(binding.post);

    }
}
