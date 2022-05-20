package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.Restauration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Delevery")

public class Conroller_Delevery {
    @GetMapping("/ajoutResto")
    public String ajoutResto(){
        Restauration resto1=new Restauration();
        return "ok";
    }
}
