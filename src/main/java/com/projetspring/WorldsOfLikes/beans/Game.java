package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    public static String combat(Heros heros, Monstres monstre) {
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
    public static String combat(Heros heros1, Heros heros2) {
        String vainqueur = "";
        vie(heros1, heros2);
        if (heros1.getVitesse() >= heros2.getVitesse()) {
            while (heros1.getPointDeVie() > 0 && heros2.getPointDeVie() > 0) {
                vie(heros1, heros2);
                taper(heros1, heros2);
                if (heros2.getPointDeVie() <= 0) {
                    gains(heros1, heros2);
                    vainqueur = heros1.getNom();
                    return "Le vainqueur est " + vainqueur;
                }
                vie(heros1, heros2);
                taper(heros2, heros1);
                if (heros1.getPointDeVie() <= 0) {
                    gains(heros2, heros1);
                    vainqueur = heros2.getNom();
                    return "Le vainqueur est " + vainqueur;
                }
            }
        } else {
            while (heros1.getPointDeVie() > 0 && heros2.getPointDeVie() > 0) {
                vie(heros1, heros2);
                taper(heros2, heros1);
                if (heros1.getPointDeVie() <= 0) {
                    gains(heros2, heros1);
                    vainqueur = heros2.getNom();
                    return "Le vainqueur est " + heros2.getNom();
                }
            }
            vie(heros1, heros2);
            taper(heros1, heros2);
            if (heros2.getPointDeVie() <= 0) {
                gains(heros1, heros2);
                vainqueur = heros1.getNom();
                return "Le vainqueur est " + heros1.getNom();
            }
        }
        return "";
    }

    // Méthode gains fin de combat
    public static void gains(Heros heros, Monstres monstre) {
        int xpBaseHeros = heros.getExperience();
        heros.setExperience(xpBaseHeros + 5 * monstre.getNiveau() * heros.getCoeffXpXp());
        int ora = heros.getOr();
        heros.actuNiveau();
        heros.setOr(ora + randomBox(1, 30 + monstre.getNiveau()));

    }
    public static void gains(Heros heros, Heros monstre) {
        int xpBaseHeros = heros.getExperience();
        heros.setExperience(xpBaseHeros + 5 * monstre.getNiveau() * heros.getCoeffXpXp());
        int ora = heros.getOr();
        heros.actuNiveau();
        heros.setOr(ora + randomBox(1, 30 + monstre.getNiveau()));

    }


    // Méthodes pour afficher statistiques pendant le combat
    public static void vie(Personnage numeroUn, Personnage numeroDeux) {
        System.out.println("Personnage : " + numeroUn.getNom() + "       | PDV : " + numeroUn.getPointDeVie() + "      | Mana : " + numeroUn.mana);
        System.out.println("Personnage : " + numeroDeux.getNom() + "     | PDV : " + numeroDeux.getPointDeVie() + "      | Mana : " + numeroDeux.mana);

    }

    //Méthodes pour taper
    public static void taper(Heros attaquant, Personnage defenseur) {
        int taper = Math.abs(randomBox(defenseur.defense + 1, (attaquant.attaque - defenseur.defense)));
        if (taper == attaquant.attaque - defenseur.defense) {
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
    public static void taper(Personnage attaquant, Personnage defenseur) {
        int taper = Math.abs(randomBox(defenseur.defense -1, (attaquant.attaque - defenseur.defense)));
        System.out.println(taper);
        if (taper == attaquant.attaque - defenseur.defense) {
            System.out.println("Coup Critique !");
        }
        defenseur.setPointDeVie(defenseur.getPointDeVie() - taper);
    }
    public static int taperMagie(Heros attaquant, Personnage defenseur) {
        int taper = randomBox(1, (attaquant.attaque) * attaquant.getPuissMagique());
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

