package com.projetspring.WorldsOfLikes.beans;

public class Auxiliaire {
    int id;

    public Auxiliaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Auxiliaire{" +
                "id=" + id +
                '}';
    }
}
