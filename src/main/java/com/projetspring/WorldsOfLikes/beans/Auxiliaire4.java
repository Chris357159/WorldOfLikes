package com.projetspring.WorldsOfLikes.beans;

public class Auxiliaire4 {
    private int id;
    private int idFollower;
    private String username;
    private String userPhoto;
    //constructeurs
    public Auxiliaire4() {
    }
    //getteurs setteurs
    public int getIdFollower() {
        return idFollower;
    }

    public void setIdFollower(int idFollower) {
        this.idFollower = idFollower;
    }

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
                ", idFollower=" + idFollower +
                ", username='" + username + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}
