package com.projetspring.WorldsOfLikes.beans;

public class Monstres extends Personnage{
    private int niveau = 0;


    //Constructor

    public Monstres(int niveau) {
        this.niveau = niveau;
    }

    public Monstres(String nom, int pointDeVieMax, int pointDeVie, int attaque, int defense, int vitesse, int mana, int or, int niveau) {
        super(nom, pointDeVieMax, pointDeVie, attaque, defense, vitesse, mana, or);
        this.niveau = niveau;
    }

    public Monstres() {
    }

    //Getters & Setters

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
