package com.example.figmamc.activities.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.databinding.PhotoListBinding;

public class PhotoHolder extends RecyclerView.ViewHolder {
    private PhotoListBinding binding;
    private PhotoClickListener listener;
    public PhotoHolder(PhotoListBinding binding,PhotoClickListener listener) {

    }
    public void bind(Photo item){

    }
}
