package com.example.figmamc.activities.activity.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.figmamc.activities.Entity.Club;
import com.example.figmamc.activities.adapter.ClubAdapter;
import com.example.figmamc.databinding.ClubsBinding;

import java.util.ArrayList;

public class ClubsFragment extends Fragment {
    ClubsBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ClubsBinding.inflate(inflater);
        Club[] clubs = new Club[2];
        clubs[0]=new Club("Tralala","10 hours","ssilka");
        clubs[1]=new Club("Requiem","5 min","ssilka");
        binding.list.setAdapter(new ClubAdapter(getContext(), clubs));
        return binding.getRoot();
    }
}
