package com.projetspring.WorldsOfLikes.beans;

public class UserAdresse {
    private int id;
    private String adresse;

    public UserAdresse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "UserAdresse{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
