package com.example.figmamc.activities.Entity;

public class Battle {
    public String name;
    public String votes_num;
    public String type;
    public int image;

    public Battle(String name, String votes_num, String type, int image) {
        this.name = name;
        this.votes_num = votes_num;
        this.type = type;
        this.image = image;
    }
}
