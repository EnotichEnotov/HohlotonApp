package com.example.figmamc.activities.Entity;

public class Photo {
    private long id;
    private long userId;
    private String photoText;
    private String photoUrl;
    public Photo(long id,long userId,String photoUrl,String photoText){
        this.id=id;
        this.photoText=photoText;
        this.photoUrl=photoUrl;
        this.userId=userId;
    }

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPhotoText() {
        return photoText;
    }
}
