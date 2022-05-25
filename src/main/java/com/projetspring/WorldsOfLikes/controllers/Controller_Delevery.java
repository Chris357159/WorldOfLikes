package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.Restauration;
import com.projetspring.WorldsOfLikes.repositories.MenuRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.RestoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Delevery")

public class Conroller_Delevery {
    @Autowired
    private RestoRepositoryInterface restoRepositoryInterface;
    @Autowired
    private MenuRepositoryInterface menuRepositoryInterface;

    @GetMapping("/ajoutResto")
    public String ajoutResto(){
        Restauration resto1=new Restauration();
        return "ok";
    }

    @GetMapping("/envoiData")
    public List<Restauration> envoiData(){
        List<Restauration> a = restoRepositoryInterface.findAll();
        return a;
    }

    @GetMapping("/recupRestaurantMenu")
    public Restauration recupRestaurantMenu(){
        return restoRepositoryInterface.findById(1);
    }
}

