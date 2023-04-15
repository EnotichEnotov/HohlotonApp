package com.example.figmamc;
public class Membership {
    private long id;
    private long userId;
    private long clubsId;
    public Membership(long id,long userId,long clubsId){
        this.id=id;
        this.clubsId=clubsId;
        this.userId=userId;
    }

    public long getId() {
        return id;
    }

    public long getClubsId() {
        return clubsId;
    }

    public long getUserId() {
        return userId;
    }
}
