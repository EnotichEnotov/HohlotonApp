package com.example.figmamc.activities.activity.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.figmamc.activities.Entity.Membership;
import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.MembershipApi.PhotoApi;
import com.example.figmamc.activities.Services.MembershipApiService;
import com.example.figmamc.activities.Services.PhotoApiService;
import com.example.figmamc.activities.adapter.PhotoAdapter;
import com.example.figmamc.activities.adapter.PhotoClickListener;
import com.example.figmamc.databinding.LentaBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoFragment extends Fragment {
    LentaBinding binding;
    private PhotoAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LentaBinding.inflate(inflater);
        adapter = new PhotoAdapter(new PhotoClickListener() {
            @Override
            public void onClick(long id) {

            }
        });
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(0,0,
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livemaster.ru%2Ftopic%2F3152535-kotiki-spasut-mir-25-valyanyh-pitomtsev-na-kotoryh-nevozmozhno-smotret-bez-umileniya&psig=AOvVaw2obyMgC9t9k4efxsRZBTs7&ust=1681650124946000&source=images&cd=vfe&ved=0CA4QjRxqFwoTCJiqx4T5q_4CFQAAAAAdAAAAABAE","Bebra"));
        adapter.setItems(photos);
        return binding.getRoot();
    }


}
