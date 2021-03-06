package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.*;

import com.projetspring.WorldsOfLikes.repositories.UserDataRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.MenuRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.RestoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Delevery")
@CrossOrigin("*")
public class Controller_Delivery {

    //Create DB
    @Autowired
    private RestoRepositoryInterface restoRepositoryInterface;

    @Autowired
    private MenuRepositoryInterface menuRepositoryInterface;

    @Autowired
   private UserDataRepositoryInterface userDataRepositoryInterface; //pour get UserId lors de commande




    @GetMapping("/getUserId/{id}")
    public UserData getUserId(@PathVariable int id)
    {
        return userDataRepositoryInterface.findById(id);
    }

    //si user a déjà une adresse, on affirme, sinon ajouter son adresse dans la database

    @PostMapping("/addUserAdresse")
    public UserData addUserAdresse(@RequestBody UserAdresse u){

        UserData userData = userDataRepositoryInterface.findById(u.getId());
        userData.setAdresse(u.getAdresse());
        userDataRepositoryInterface.save(userData);
        return userData;

    }



    @GetMapping("/ajoutResto")
    public String ajoutResto(){
        Restauration resto1=new Restauration();
        return "ok";
    }

    @GetMapping("/ajoutMenuResto")
    public String ajoutMenuResto(){
        Restauration Resto = new Restauration("La causette", "Morsang-sur-Orge");
        Menu menu1=  new Menu( "menu Pizza",  15);
        Menu menu2=  new Menu( "menu Tacos",  7);
        Resto.ajouterMenu(menu1);
        Resto.ajouterMenu(menu2);
        restoRepositoryInterface.save(Resto);
        return "ok";
    }

    @GetMapping("/recupResto")
    public List <Restauration> recupResto(){

        List <Restauration> tab =restoRepositoryInterface.findAll();
        return tab;
    }

    //@PostMapping(value="/commandeDisplay",produces = "application/json")
    //public void commandeDisplay(@RequestBody ){}

    //--------------pour récupérer tous les menus -----------//
    @GetMapping("/getTousLesMenus")
    public List <Menu> getTousLesMenus(){
        List <Menu> m= menuRepositoryInterface.findAll();
        return m;
    }











    /*@GetMapping("/commandeDisplay")
    public List <Menu>commandeDisplay(){
       int [] nbr= {1,4};
       ArrayList<Restauration> restoList = new ArrayList<>();
       ArrayList<Menu> menuList = new ArrayList<>();
       for (int i=0; i<nbr.length; i++){
          Menu m= menuRepositoryInterface.findById(nbr[i]);

           //new Menu
           Menu a= new Menu();
           a.setIdMenu(m.getIdMenu());
           a.setMenu(m.getMenu());
           a.setPrice(m.getPrice());
           menuList.add(a);

       }
       return menuList;


    }*/







}
