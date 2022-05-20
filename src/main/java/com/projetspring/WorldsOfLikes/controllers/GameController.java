package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.*;
import com.projetspring.WorldsOfLikes.repositories.FormRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.GameRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Game")
public class GameController {
    @Autowired
    private GameRepositoryInterface gameRepositoryInterface;

    @GetMapping("/CombatMonstres")
    public String combatMonstres (@RequestBody Heros personnage1, @RequestBody Monstres monstre1) {
        return Game.combat(personnage1, monstre1);
    }



}
