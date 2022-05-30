package com.projetspring.WorldsOfLikes.beans;

public class Auxiliaire2 {
    private int id;
    private String userPhoto;

    public Auxiliaire2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public String toString() {
        return "Auxiliaire2{" +
                "id=" + id +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}
