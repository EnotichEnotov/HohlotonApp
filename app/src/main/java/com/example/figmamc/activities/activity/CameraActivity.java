package com.example.figmamc.activities.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.figmamc.databinding.CameraActivityBinding;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class CameraActivity extends AppCompatActivity {
    private CameraActivityBinding binding;
    private static final int PERMISSION_REQ_CODE = 10;

    private boolean allPermissionsGranted(){
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CameraActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(allPermissionsGranted()){
            startCamera();
        }
        else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQ_CODE
            );
        }
    }

    private void startCamera() {
        ListenableFuture<ProcessCameraProvider> listenableFuture =
                ProcessCameraProvider.getInstance(this);
        listenableFuture.addListener(()->{
                    try {
                        ProcessCameraProvider cameraProvider = listenableFuture.get();
                        CameraSelector cameraSelector = new CameraSelector.Builder()
                                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                                .build();
                        Preview preview = new Preview.Builder().build();
                        preview.setSurfaceProvider(binding.pvCamera.getSurfaceProvider());
                        Camera camera = cameraProvider.bindToLifecycle(this,cameraSelector,preview);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                ContextCompat.getMainExecutor(this));
        Log.i("III", "startCamera: bebra");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_REQ_CODE){
            if(allPermissionsGranted()){
                startCamera();
            }
        }
    }
}
