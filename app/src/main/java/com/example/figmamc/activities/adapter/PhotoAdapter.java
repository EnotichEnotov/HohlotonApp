package com.example.figmamc.activities.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.figmamc.activities.Entity.Membership;
import com.example.figmamc.activities.Entity.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
    private List<Photo> items = new ArrayList<>();
    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
