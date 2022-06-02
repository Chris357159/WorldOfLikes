package com.projetspring.WorldsOfLikes.controllers;

import com.projetspring.WorldsOfLikes.beans.Auxiliaire7;
import com.projetspring.WorldsOfLikes.beans.UserData;
import com.projetspring.WorldsOfLikes.beans.Auxiliaire5;
import com.projetspring.WorldsOfLikes.beans.UserProfile;
import com.projetspring.WorldsOfLikes.repositories.UserDataRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.UserProfileRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/API")
public class MainWebController {

    //Create DB
    @Autowired
    private UserDataRepositoryInterface userDataRepositoryInterface;
    @Autowired
    private UserProfileRepositoryInterface userProfileRepositoryInterface;
    //Insert new registration
    @PostMapping("/registrer")
    public String registrer(@RequestBody UserData userData_register){
        int nombreMail = userDataRepositoryInterface.countByEmail(userData_register.getEmail());
        if(nombreMail > 0){
            return "MailAlreadyExist";
        }
        else{
            userDataRepositoryInterface.save(userData_register);
        }
        return "Ok";
    }

    //Login
    @PostMapping("/login")
    public int login(@RequestBody UserData userData_register){
        UserData connexion = userDataRepositoryInterface.findByEmail(userData_register.getEmail());
        if(connexion == null){
            return 0;
        }
        else if(!connexion.getMotdepasse().equals(userData_register.getMotdepasse())){
            return 0;
        }
        else{
            return (connexion.getID());
        }
    }

    @PostMapping("/logged")
    public int logged(@RequestBody Auxiliaire5 form_register){
        UserData connexion = userDataRepositoryInterface.findByEmail(form_register.getMonEmail());
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
    //
    @PostMapping("/register")
    public String register(@RequestBody Auxiliaire7 userData_register){
        int nombreMail = userDataRepositoryInterface.countByEmail(userData_register.getMyEmail());
        if(nombreMail > 0){
            return "MailAlreadyExist";
        }
        else{
            UserData userData=new UserData(userData_register.getMyEmail(),userData_register.getMyPassword(),userData_register.getMyAddress());
            UserProfile userProfile=new UserProfile("Username","heart.png",0,0,userData);
            userProfileRepositoryInterface.save(userProfile);
            userData.setSocialNetwork(userProfile);
            userDataRepositoryInterface.save(userData);
        }
        return "Ok";
    }
}
