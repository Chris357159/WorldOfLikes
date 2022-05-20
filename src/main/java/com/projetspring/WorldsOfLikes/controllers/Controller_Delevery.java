package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.Restauration;
import com.projetspring.WorldsOfLikes.repositories.RestoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Delevery")

public class Controller_Delevery {

    //Create DB
    @Autowired
    private RestoRepositoryInterface restoRepositoryInterface;

    @GetMapping("/ajoutResto")
    public String ajoutResto(){
        Restauration resto1=new Restauration();
        return "ok";
    }
}
