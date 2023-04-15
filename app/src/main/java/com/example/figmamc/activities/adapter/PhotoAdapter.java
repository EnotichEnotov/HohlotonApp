package com.example.figmamc.activities.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.figmamc.activities.Entity.Membership;
import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.databinding.PhotoListBinding;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
    private List<Photo> items = new ArrayList<>();
    PhotoClickListener listener;
    public PhotoAdapter(PhotoClickListener listener){
        this.listener=listener;
    }
    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PhotoListBinding binding = PhotoListBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new PhotoHolder(binding,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setItems(List<Photo> items){
        int count = getItemCount();
        this.items=new ArrayList<>(items);
        notifyItemRangeChanged(0,Math.max(count,getItemCount()));
    }
}
