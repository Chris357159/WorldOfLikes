package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int ID;
    protected String nom;

    public Equipment(String nom) {
        this.nom = nom;
    }

    public Equipment(){}

    //Getters&Setters


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                '}';
    }
}
