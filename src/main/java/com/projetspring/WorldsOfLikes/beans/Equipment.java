package com.projetspring.WorldsOfLikes.beans;

public class Equipment {
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
}
