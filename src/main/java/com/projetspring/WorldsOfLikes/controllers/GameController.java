package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.*;
import com.projetspring.WorldsOfLikes.repositories.FormRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.GameRepositoryInterface;
import com.projetspring.WorldsOfLikes.services.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Game")
public class GameController {

    @Autowired
    private FormRepositoryInterface formRepositoryInterface;

    //Create DB
    @Autowired
    private GameRepositoryInterface gameRepositoryInterface;

    @GetMapping("/combatMonstres")
    public String combatMonstres (@RequestBody Heros heros1, @RequestBody Monstres monstre1, @RequestBody Form form_perso) {

        Form connexion1 = formRepositoryInterface.findByEmail(form_perso.getEmail());
        return Game.combat(heros1, monstre1);
    }

    @GetMapping("/testGame")
    public String testGame() {
        return ("OK");
    }
}
