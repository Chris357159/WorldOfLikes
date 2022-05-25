package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.*;

@Entity
public class Form {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String email;
    private String motdepasse;
    /*@OneToOne(fetch = FetchType.EAGER)
    private SocialNetwork socialNetwork;

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }*/

    //Consctructors
    public Form() {
    }
    public Form(String email, String motdepasse) {
        this.email = email;
        this.motdepasse = motdepasse;
    }

    //Get/Set
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
}
