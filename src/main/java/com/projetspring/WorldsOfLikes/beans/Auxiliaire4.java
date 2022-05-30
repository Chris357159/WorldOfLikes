package com.projetspring.WorldsOfLikes.beans;

public class Auxiliaire4 {
    private int id;
    private String username;
    private String userPhoto;

    //constructeurs
    public Auxiliaire4(int id, String username, String userPhoto) {
        this.id = id;
        this.username = username;
        this.userPhoto = userPhoto;
    }

    public Auxiliaire4() {
    }
    //getteurs setteurs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public String toString() {
        return "Auxiliaire4{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}
