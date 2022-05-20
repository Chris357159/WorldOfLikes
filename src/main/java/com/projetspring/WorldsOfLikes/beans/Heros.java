package com.projetspring.WorldsOfLikes.beans;

public class Heros extends Personnage{
    private int experience = 0;
    private int niveau = 1;
    private int coutMagie = 5;
    protected Equipment[] equipement = new Equipment[3];
    private int puissMagique = 1;
    private int coeffXpAtq = 1;
    private int coeffXpDef = 1;
    private int coeffXpXp = 10;
    private int vol = 0;

    //Constructor

    public Heros() {
    }

    public void actuNiveau() {
        int atqBase = this.getAttaque();
        int defBase = this.getDefense();
        int pdvBase = this.getPointDeVieMax();
        int vitBase = this.getVitesse();
        int nivBase = this.getNiveau();

        while (this.experience > (10*Math.pow(2,(this.niveau)+1))){
            this.niveau +=1;
            this.experience-=this.coeffXpXp*(int)Math.pow(2,this.niveau);
        }
        this.attaque+=5*(this.getNiveau()-nivBase)*coeffXpAtq;
        this.defense+=4*(this.getNiveau()-nivBase)*coeffXpDef;
        this.setPointDeVieMax(pdvBase + 10*(this.getNiveau()-nivBase));
        this.setVitesse(vitBase + 50*(this.getNiveau()-nivBase));
    }

    //Getters and Setters

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getCoutMagie() {
        return coutMagie;
    }

    public void setCoutMagie(int coutMagie) {
        this.coutMagie = coutMagie;
    }

    public Equipment[] getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipment[] equipement) {
        this.equipement = equipement;
    }

    public int getPuissMagique() {
        return puissMagique;
    }

    public void setPuissMagique(int puissMagique) {
        this.puissMagique = puissMagique;
    }

    public int getCoeffXpAtq() {
        return coeffXpAtq;
    }

    public void setCoeffXpAtq(int coeffXpAtq) {
        this.coeffXpAtq = coeffXpAtq;
    }

    public int getCoeffXpDef() {
        return coeffXpDef;
    }

    public void setCoeffXpDef(int coeffXpDef) {
        this.coeffXpDef = coeffXpDef;
    }

    public int getCoeffXpXp() {
        return coeffXpXp;
    }

    public void setCoeffXpXp(int coeffXpXp) {
        this.coeffXpXp = coeffXpXp;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }
}
