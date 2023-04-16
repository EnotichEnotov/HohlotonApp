package com.example.figmamc.activities.activity.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.figmamc.activities.Api.repository.PhotoRepository;
import com.example.figmamc.activities.Entity.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoViewModel extends androidx.lifecycle.ViewModel {
    private MutableLiveData<List<Photo>> _photos = new MutableLiveData<>();

    public LiveData<List<Photo>> photos = _photos;
    public void load(){
        PhotoRepository.getPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                _photos.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
