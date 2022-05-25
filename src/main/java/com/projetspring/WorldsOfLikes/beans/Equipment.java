package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    protected String nomEpee;
    protected int atqEpee;
    protected String nomArmure;
    protected int defArmure;
    protected String nomBottes;
    protected int vitBottes;



    public Equipment(String nomEpee, int atqEpee, String nomArmure, int defArmure, String nomBottes, int vitBottes) {
        this.nomEpee = nomEpee;
        this.atqEpee = atqEpee;
        this.nomArmure = nomArmure;
        this.defArmure = defArmure;
        this.nomBottes = nomBottes;
        this.vitBottes = vitBottes;
    }

    public Equipment() {
    }

    //Getters&Setters

    public String getNomEpee() {
        return nomEpee;
    }

    public void setNomEpee(String nomEpee) {
        this.nomEpee = nomEpee;
    }

    public int getAtqEpee() {
        return atqEpee;
    }

    public void setAtqEpee(int atqEpee) {
        this.atqEpee = atqEpee;
    }

    public String getNomArmure() {
        return nomArmure;
    }

    public void setNomArmure(String nomArmure) {
        this.nomArmure = nomArmure;
    }

    public int getDefArmure() {
        return defArmure;
    }

    public void setDefArmure(int defArmure) {
        this.defArmure = defArmure;
    }

    public String getNomBottes() {
        return nomBottes;
    }

    public void setNomBottes(String nomBottes) {
        this.nomBottes = nomBottes;
    }

    public int getVitBottes() {
        return vitBottes;
    }

    public void setVitBottes(int vitBottes) {
        this.vitBottes = vitBottes;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "nomEpee='" + nomEpee + '\'' +
                ", atqEpee=" + atqEpee +
                ", nomArmure='" + nomArmure + '\'' +
                ", defArmure=" + defArmure +
                ", nomBottes='" + nomBottes + '\'' +
                ", vitBottes=" + vitBottes +
                ", ID=" + ID +
                '}';
    }
}
