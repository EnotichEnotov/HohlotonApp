package com.example.figmamc.activities.activity.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.figmamc.activities.Entity.Battle;
import com.example.figmamc.activities.Entity.Club;
import com.example.figmamc.activities.adapter.BattleAdapter;
import com.example.figmamc.databinding.BattlesBinding;

public class PhotoBattlesFragment extends Fragment {
    BattlesBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BattlesBinding.inflate(inflater);
        Battle[] battles = new Battle[2];
        battles[0]=new Battle("Capibara","123","phote Capibara",1);
        battles[1]=new Battle("Comparator","555","Do code comparator",1);
        binding.list.setAdapter(new BattleAdapter(getContext(),battles));
        return binding.getRoot();
    }
}
