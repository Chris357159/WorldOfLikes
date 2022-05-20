package com.projetspring.WorldsOfLikes.beans;


    public class Personnage {
        protected String nom;
        protected int PointDeVieMax;
        protected int PointDeVie;
        protected int attaque;
        protected int defense;
        protected int vitesse;
        protected int mana;
        private int or = 0;

        //Constructor

        public Personnage() {
        }

        public Personnage(String nom, int pointDeVieMax, int pointDeVie, int attaque, int defense, int vitesse, int mana, int or) {
            this.nom = nom;
            PointDeVieMax = pointDeVieMax;
            PointDeVie = pointDeVie;
            this.attaque = attaque;
            this.defense = defense;
            this.vitesse = vitesse;
            this.mana = mana;
            this.or = or;
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

        public int getOr() {
            return or;
        }

        public void setOr(int or) {
            this.or = or;
        }
    }
