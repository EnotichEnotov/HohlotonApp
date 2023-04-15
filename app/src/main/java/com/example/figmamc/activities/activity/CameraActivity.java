package com.example.figmamc.activities.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.figmamc.activities.Entity.Photo;
import com.example.figmamc.activities.Services.PhotoApiService;
import com.example.figmamc.activities.activity.main.MainActivity;
import com.example.figmamc.databinding.CameraActivityBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.net.URI;
import java.util.concurrent.ExecutionException;

public class CameraActivity extends AppCompatActivity {
    private CameraActivityBinding binding;
    public static final String PATH = "Path dir";
    private final String pathToImageStorage = "gs://battle-867f7.appspot.com";
    private static final int PERMISSION_REQ_CODE = 10;
    private ImageCapture imageCapture;

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
        binding.camBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
    }

    private void takePhoto() {
        if(imageCapture == null){
            return;
        }
        String path = "image"+(int)(Math.random()*100)+".png";
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),path);
        ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.
                Builder(file).build();
        imageCapture.takePicture(
                outputFileOptions,
                ContextCompat.getMainExecutor(this),
                new ImageCapture.OnImageSavedCallback() {
                    @Override
                    public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                        Log.i(PATH,file.getAbsolutePath());
                    }

                    @Override
                    public void onError(@NonNull ImageCaptureException exception) {
                        Log.e(PATH,exception.getMessage());
                    }
                }
        );
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(pathToImageStorage);
        StorageReference reference = firebaseStorage.getReference();
        reference = reference.child("images/");
        Uri uri = Uri.parse(file.toURI().toString());
        reference.putFile(uri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                Toast.makeText(CameraActivity.this,"Uploaded",Toast.LENGTH_LONG).show();
                            }
                        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CameraActivity.this,"Failed"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress = (100.0*snapshot.getBytesTransferred()/snapshot
                                .getTotalByteCount());
                        Log.i("III","Uploaded "+(int)progress+"%");
                    }
                });

        PhotoApiService.getInstance().setPhoto(new Photo(0,0, path,binding.postText.getText().toString()));
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
                        imageCapture = new ImageCapture.Builder().build();
                        Camera camera = cameraProvider.bindToLifecycle(
                                this,cameraSelector,
                                preview,imageCapture);
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                ContextCompat.getMainExecutor(this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_REQ_CODE){
            if(allPermissionsGranted()){
                startCamera();
            }
            else{
                finish();
            }
        }
    }
}
