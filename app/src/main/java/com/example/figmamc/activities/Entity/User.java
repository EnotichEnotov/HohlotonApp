package com.example.figmamc.activities.Entity;

public class User {
    private String name;
    private long rating;
    private long phone;
    private long hashPassword;
    private String avaUrl;

    public User(String name, long rating, long phone, long hashPassword, String avaUrl) {
        this.name = name;
        this.rating = rating;
        this.phone = phone;
        this.hashPassword = hashPassword;
        this.avaUrl = avaUrl;
    }

    public String getName() {
        return name;
    }

    public long getRating() {
        return rating;
    }

    public long getPhone() {
        return phone;
    }

    public long getHashPassword() {
        return hashPassword;
    }

    public String getAvaUrl() {
        return avaUrl;
    }
}
