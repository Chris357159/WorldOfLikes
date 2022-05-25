package com.projetspring.WorldsOfLikes.beans;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restauration {
    //Attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResto;
    private String nomResto;
    private String adresseResto;

    //ajouter plusieurs menus
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Menu> menutab = new ArrayList<>();

    public void ajouterMenu(Menu menu){
        menutab.add(menu);
    }


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

    public List<Menu> getMenutab() {
        return menutab;
    }

    public void setMenutab(List<Menu> menutab) {
        this.menutab = menutab;
    }
}
