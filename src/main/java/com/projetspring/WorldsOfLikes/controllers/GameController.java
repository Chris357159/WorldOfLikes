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
    public String combatMonstres () {
        Personnage heros = new Personnage("heros", 120, 120, 120, 120, 120, 120, 120);
        Personnage monstre1 = new Personnage("monstre", 120, 120, 120, 120, 120, 120, 120);
        return Game.combat(heros, monstre1);
    }

    //Login
    @PostMapping("/play")
    public String play(@RequestBody Form form_play){
        Form play = formRepositoryInterface.findByEmail(form_play.getEmail());
        if(play == null){
            return "Bad Credentials";
        }
        else if(!play.getMotdepasse().equals(form_play.getMotdepasse())){
            return "Bad Password";
        }
        else{
            return ("" + play.getID());
        }
    }

    @GetMapping("/testGame")
    public String testGame() {
        return ("OK");
    }
}
