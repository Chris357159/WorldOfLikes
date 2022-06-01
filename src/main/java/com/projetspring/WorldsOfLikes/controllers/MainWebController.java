package com.projetspring.WorldsOfLikes.controllers;

import com.projetspring.WorldsOfLikes.beans.Form;
import com.projetspring.WorldsOfLikes.beans.Auxliaire5;
import com.projetspring.WorldsOfLikes.repositories.FormRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/API")
public class MainWebController {

    //Create DB
    @Autowired
    private FormRepositoryInterface formRepositoryInterface;

    //Insert new registration
    @PostMapping("/registrer")
    public String registrer(@RequestBody Form form_register){
        int nombreMail = formRepositoryInterface.countByEmail(form_register.getEmail());
        if(nombreMail > 0){
            return "MailAlreadyExist";
        }
        else{
            formRepositoryInterface.save(form_register);
        }
        return "Ok";
    }

    //Login
    @PostMapping("/login")
    public int login(@RequestBody Form form_register){
        Form connexion = formRepositoryInterface.findByEmail(form_register.getEmail());
        if(connexion == null){
            return 0;
        }
        else if(!connexion.getMotdepasse().equals(form_register.getMotdepasse())){
            return 0;
        }
        else{
            return (connexion.getID());
        }
    }
    @PostMapping("/logged")
    public int logged(@RequestBody Auxliaire5 form_register){
        Form connexion = formRepositoryInterface.findByEmail(form_register.getMonEmail());
        if(connexion == null){
            return 0;
        }
        else if(!connexion.getMotdepasse().equals(form_register.getMonMotdepasse())){
            return 0;
        }
        else{
            return (connexion.getID());
        }
    }
}
