package com.projetspring.WorldsOfLikes.services;

import com.projetspring.WorldsOfLikes.beans.Personnage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    //Méthodes de combat
    public static String combat(Personnage heros, Personnage monstre) {
        String vainqueur = "";
        vie(heros, monstre);
        if (heros.getVitesse() >= monstre.getVitesse()) {
            while (heros.getPointDeVie() > 0 && monstre.getPointDeVie() > 0) {
                vie(heros, monstre);
                taper(heros, monstre);
                if (monstre.getPointDeVie() <= 0) {
                    gains(heros, monstre);
                    vainqueur = heros.getNom();
                    return "Le vainqueur est " + vainqueur;
                }
                vie(heros, monstre);
                taper(monstre, heros);
                if (heros.getPointDeVie() <= 0) {
                    vainqueur = monstre.getNom();
                    return "Vous avez perdu.";
                }
            }
        } else {
            while (heros.getPointDeVie() > 0 && monstre.getPointDeVie() > 0) {
                vie(heros, monstre);
                taper(monstre, heros);
                if (heros.getPointDeVie() <= 0) {
                    gains(heros, monstre);
                    vainqueur = monstre.getNom();
                    return "Vous avez perdu";
                }
                vie(heros, monstre);
                taper(heros, monstre);
                if (monstre.getPointDeVie() <= 0) {
                    vainqueur = heros.getNom();
                    return "Le vainqueur est " + heros.getNom();
                }
            }
        }
        return "";
    }


    // Méthode gains fin de combat
    public static void gains(Personnage heros, Personnage monstre) {
        int xpBaseHeros = heros.getExperience();
        heros.setExperience(xpBaseHeros + 5 * monstre.getNiveau() * heros.getCoeffXpXp());
        int ora = heros.getOr();
        heros.actuNiveau();
        heros.setOr(ora + randomBox(1, 30 + monstre.getNiveau()));

    }

    // Méthodes pour afficher statistiques pendant le combat
    public static void vie(Personnage numeroUn, Personnage numeroDeux) {
        System.out.println("Personnage : " + numeroUn.getNom() + "       | PDV : " + numeroUn.getPointDeVie() + "      | Mana : " + numeroUn.getMana());
        System.out.println("Personnage : " + numeroDeux.getNom() + "     | PDV : " + numeroDeux.getPointDeVie() + "      | Mana : " + numeroDeux.getMana());

    }

    //Méthodes pour taper
    public static void taper(Personnage attaquant, Personnage defenseur) {
        int taper = Math.abs(randomBox(defenseur.getDefense() + 1, (attaquant.getAttaque() - defenseur.getDefense())));
        if (taper == attaquant.getAttaque() - defenseur.getDefense()) {
            System.out.println("Coup Critique !");
        }
        if (attaquant.getMana() >= attaquant.getCoutMagie()) {
            defenseur.setPointDeVie(defenseur.getPointDeVie()-taperMagie(attaquant, defenseur));
        }
        if (attaquant.getVol() > 0) {
            int vol = attaquant.getOr() + randomBox(1, defenseur.getOr());
            attaquant.setOr(vol);
            defenseur.setOr(defenseur.getOr() - vol);
        }
        defenseur.setPointDeVie(defenseur.getPointDeVie() - taper);
    }

    public static int taperMagie(Personnage attaquant, Personnage defenseur) {
        int taper = randomBox(1, (attaquant.getAttaque()) * attaquant.getPuissMagique());
        System.out.println("Je vais tenter un sort !");
        attaquant.mana -= attaquant.getCoutMagie();
        if (attaquant.getVol() > 0) {
            int vol = attaquant.getOr() + randomBox(1, defenseur.getOr());
            attaquant.setOr(vol);
            defenseur.setOr(defenseur.getOr() - vol);
        }
        return taper;
    }
    static int randomBox(int low, int high) {
        if (high <= low) {
            return 0;
        }
        return Math.abs((int) (Math.random() * (high - low)) + low);
    }

}

