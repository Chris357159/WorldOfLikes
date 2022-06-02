package com.projetspring.WorldsOfLikes.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class UserData {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String email;
    private String motdepasse;
    private String adresse;

    @JsonIgnoreProperties("login")
    @OneToOne(fetch = FetchType.EAGER)
    private UserProfile userProfile;
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private ParametresUtilisateur form_parametresUtilisateurs;
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Personnage form_personnage;

    //Consctructors
    public UserData() {
    }

    public UserData(String email, String motdepasse, String adresse) {
        this.email = email;
        this.motdepasse = motdepasse;
        this.adresse = adresse;
    }

    public UserData(String email, String motdepasse) {
        this.email = email;
        this.motdepasse = motdepasse;
    }

    //Get and Set attribute
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMotdepasse() {
        return motdepasse;
    }
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Get and Set class
    public UserProfile getSocialNetwork() {
        return userProfile;
    }

    public void setSocialNetwork(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public ParametresUtilisateur getForm_parametresUtilisateurs() {
        return form_parametresUtilisateurs;
    }

    public void setForm_parametresUtilisateurs(ParametresUtilisateur form_parametresUtilisateurs) {
        this.form_parametresUtilisateurs = form_parametresUtilisateurs;
    }

    public Personnage getForm_personnage() {
        return form_personnage;
    }
    public void setForm_personnage(Personnage form_personnage) {
        this.form_personnage = form_personnage;
    }

    public void save(UserAdresse u) {
    }
}
