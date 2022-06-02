package com.projetspring.WorldsOfLikes.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.catalina.User;

import javax.persistence.*;


@Entity
public class Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    protected String nom;
    protected int PointDeVieMax;
    protected int PointDeVie;
    protected int attaque;
    protected int defense;
    protected int vitesse;
    public int mana;
    private int gold = 0;
    private int userData;

    //variable heros
    private int experience = 0;
    private int niveau = 1;
    private int coutMagie = 5;
    private int puissMagique = 1;
    private int coeffXpAtq = 1;
    private int coeffXpDef = 1;
    private int coeffXpXp = 10;
    private int vol = 0;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Armes perso_equip;

   /* public void ajouterValeurATK(Armes armes) {
        perso_equip.add(armes);
    }*/

    //Constructor
    public Personnage() {
    }

    public Personnage(String nom, int pointDeVieMax, int pointDeVie, int attaque, int defense, int vitesse, int mana, int gold, int userData) {
        this.nom = nom;
        PointDeVieMax = pointDeVieMax;
        PointDeVie = pointDeVie;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.mana = mana;
        this.gold = gold;
        this.userData=userData;
    }
    public Personnage(String nom, int pointDeVieMax, int pointDeVie, int attaque, int defense, int vitesse, int mana, int gold) {
        this.nom = nom;
        PointDeVieMax = pointDeVieMax;
        PointDeVie = pointDeVie;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.mana = mana;
        this.gold = gold;
    }

    public void actuNiveau() {
        int atqBase = this.getAttaque();
        int defBase = this.getDefense();
        int pdvBase = this.getPointDeVieMax();
        int vitBase = this.getVitesse();
        int nivBase = this.getNiveau();

        while (this.experience > (10 * Math.pow(2, (this.niveau) + 1))) {
            this.niveau += 1;
            this.experience -= this.coeffXpXp * (int) Math.pow(2, this.niveau);
        }
        this.attaque += 5 * (this.getNiveau() - nivBase) * coeffXpAtq;
        this.defense += 4 * (this.getNiveau() - nivBase) * coeffXpDef;
        this.setPointDeVieMax(pdvBase + 10 * (this.getNiveau() - nivBase));
        this.setVitesse(vitBase + 50 * (this.getNiveau() - nivBase));
    }

    public Personnage(String nom, int gold) {
        this.nom = nom;
        this.gold = gold;
    }
//Getters and Setters heros

    public int getUserData() {
        return userData;
    }

    public void setUserData(int userData) {
        this.userData = userData;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCoutMagie() {
        return coutMagie;
    }

    public void setCoutMagie(int coutMagie) {
        this.coutMagie = coutMagie;
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


    //Getters&Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointDeVieMax() {
        return PointDeVieMax;
    }

    public void setPointDeVieMax(int pointDeVieMax) {
        PointDeVieMax = pointDeVieMax;
    }

    public int getPointDeVie() {
        return PointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        PointDeVie = pointDeVie;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    //Getters & Setters monstres

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Equipment getPerso_equip() {
        return perso_equip;
    }

    public void setPerso_equip(Armes perso_equip) {
        this.perso_equip = perso_equip;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", PointDeVieMax=" + PointDeVieMax +
                ", PointDeVie=" + PointDeVie +
                ", attaque=" + attaque +
                ", defense=" + defense +
                ", vitesse=" + vitesse +
                ", mana=" + mana +
                ", or=" + gold +
                ", experience=" + experience +
                ", niveau=" + niveau +
                ", coutMagie=" + coutMagie +
                ", puissMagique=" + puissMagique +
                ", coeffXpAtq=" + coeffXpAtq +
                ", coeffXpDef=" + coeffXpDef +
                ", coeffXpXp=" + coeffXpXp +
                ", vol=" + vol +
                ", ID=" + ID +
                '}';
    }
}

