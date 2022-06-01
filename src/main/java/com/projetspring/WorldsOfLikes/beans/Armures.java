package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.Entity;


@Entity
public class Armures extends Equipment{
    private int valeurDEF;

    public Armures(String nom) {
        super(nom);
    }

    public Armures() {
    }

    public int getValeurDEF() {
        return valeurDEF;
    }

    public void setValeurDEF(int valeurDEF) {
        this.valeurDEF = valeurDEF;
    }
}
