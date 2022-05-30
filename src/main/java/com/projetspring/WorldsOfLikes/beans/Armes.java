package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.Entity;


@Entity
public class Armes extends Equipment {
    private int valeurATK;

    public Armes(String nom) {
        super(nom);
    }

    public Armes() {
    }

    public int getValeurATK() {
        return valeurATK;
    }

    public void setValeurATK(int valeurATK) {
        this.valeurATK = valeurATK;
    }
}
