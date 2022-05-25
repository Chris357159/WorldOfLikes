package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.*;
import com.projetspring.WorldsOfLikes.repositories.PersonnageRepositoryInterface;
import com.projetspring.WorldsOfLikes.services.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Game")
public class GameController {

    //Create DB
    @Autowired
    private PersonnageRepositoryInterface personnageRepositoryInterface;

    @GetMapping("/ajoutPersonnages")
    public String ajoutPersonnages () {
        Personnage heros = new Personnage("heros", 120, 120, 120, 120, 120, 120, 120);
        Personnage monstre1 = new Personnage("monstre", 120, 120, 120, 120, 120, 120, 120);
        return "OK";
    }


    @GetMapping("/ajoutCombatMonstres")
    public String combatMonstres () {
        Personnage heros = new Personnage("heros", 120, 120, 120, 120, 120, 120, 120);
        Personnage monstre1 = new Personnage("monstre", 120, 120, 120, 120, 120, 120, 120);
        return  Game.combat(heros, monstre1);
    }

    @GetMapping("/ajoutCombatMonstres/{ennemi}")
    public String combatEnnemi (@RequestBody Personnage ennemi) {
        Personnage heros = new Personnage("heros", 120, 120, 120, 120, 120, 120, 120);
        return Game.combat(heros, ennemi);
    }

    @GetMapping("/ajoutEquipPerso")
    public String ajoutEquipPerso () {
        Equipment epee = new Equipment("epee",120,"cotte de maille",120,"celerite",120);
        return "OK";
    }

}
