package com.projetspring.WorldsOfLikes.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restauration {
    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResto;
    private String nomResto;
    private String adresseResto;

    //Consctructors
    public Restauration() {
    }
    public Restauration(String nomResto, String adresseResto) {
        this.nomResto = nomResto;
        this.adresseResto = adresseResto;
    }

    //Methods
    @Override
    public String toString() {
        return "Restauration{" +
                "idResto=" + idResto +
                ", nomResto='" + nomResto + '\'' +
                ", adresseResto='" + adresseResto + '\'' +
                '}';
    }

    //Get/Set
    public int getIdResto() {
        return idResto;
    }
    public void setIdResto(int idResto) {
        this.idResto = idResto;
    }
    public String getNomResto() {
        return nomResto;
    }
    public void setNomResto(String nomResto) {
        this.nomResto = nomResto;
    }
    public String getAdresseResto() {
        return adresseResto;
    }
    public void setAdresseResto(String adresseResto) {
        this.adresseResto = adresseResto;
    }
}
