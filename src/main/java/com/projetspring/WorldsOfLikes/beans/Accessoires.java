package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.Entity;


@Entity
public class Accessoires extends Equipment {
    private int valeurVIT;

    public Accessoires(String nom) {
        super(nom);
    }

    public Accessoires() {
    }

    public int getValeurVIT() {
        return valeurVIT;
    }

    public void setValeurVIT(int valeurVIT) {
        this.valeurVIT = valeurVIT;
    }
}
