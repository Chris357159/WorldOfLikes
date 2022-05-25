package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.*;


@Entity
public class ParametresUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;


@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Form form_parametresUtilisateur = new Form();

}
