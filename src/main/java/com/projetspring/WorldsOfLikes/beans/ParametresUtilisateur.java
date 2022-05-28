package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.*;


@Entity
public class ParametresUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String bidule;

    public ParametresUtilisateur() {
    }

    public ParametresUtilisateur(String bidule) {
        this.bidule = bidule;
    }

    @OneToOne(fetch = FetchType.EAGER)
    private Form form_parametresUtilisateur = new Form();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
