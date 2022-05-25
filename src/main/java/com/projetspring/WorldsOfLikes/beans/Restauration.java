package com.projetspring.WorldsOfLikes.beans;


import javax.persistence.*;

@Entity
public class Restauration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idResto")
    private int idResto;
    private String nomResto;
    private String adresseResto;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Menu menu;

    public Restauration() {
    }

    public Restauration(String nomResto, String adresseResto) {
        this.nomResto = nomResto;
        this.adresseResto = adresseResto;
    }

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

    @Override
    public String toString() {
        return "Restauration{" +
                "idResto=" + idResto +
                ", nomResto='" + nomResto + '\'' +
                ", adresseResto='" + adresseResto + '\'' +
                '}';
    }
}
