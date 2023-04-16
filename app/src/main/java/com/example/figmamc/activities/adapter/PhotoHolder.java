package com.example.figmamc.activities.adapter;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.figmamc.activities.Api.repository.UserRepository;
import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.Entity.User;
import com.example.figmamc.databinding.PhotoListBinding;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PhotoHolder extends RecyclerView.ViewHolder {
    private PhotoListBinding binding;
    private final Context context;
    private final String pathToImageStorage = "gs://battle-867f7.appspot.com";
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(pathToImageStorage);
    private PhotoClickListener listener;
    public PhotoHolder(PhotoListBinding binding, Context context) {
        super(binding.getRoot());
        this.binding=binding;
        this.context=context;
    }
    public void bind(Photo item){
        binding.postText.setText(item.getPhotoText());
        Glide.with(binding.getRoot()).load(item.getPhotoUrl()).into(binding.post);
        try {
            User user = UserRepository.getById(item.getUserId());
            binding.author.setText(user.getName());
        }
        catch (Exception e){e.printStackTrace();
            Log.e("RER",item.getUserId()+"");}
        StorageReference reference = firebaseStorage.getReference(item.getPhotoUrl());
        Glide.with(context).load(reference).into(binding.post);
    }
}
