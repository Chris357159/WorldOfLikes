package com.projetspring.WorldsOfLikes.beans;

public class Auxliaire1 {
    private int id;
    private String username;

    public Auxliaire1() {
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

    @Override
    public String toString() {
        return "Auxliaire{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}