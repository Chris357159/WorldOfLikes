package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.*;
import com.projetspring.WorldsOfLikes.repositories.ArmesRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.EquipmentRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.PersonnageRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.UserDataRepositoryInterface;
import com.projetspring.WorldsOfLikes.services.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Game")
public class GameController {

    //Create DB
    @Autowired
    private PersonnageRepositoryInterface personnageRepositoryInterface;
    @Autowired
    private EquipmentRepositoryInterface equipmentRepositoryInterface;
    @Autowired
    private ArmesRepositoryInterface armesRepositoryInterface;
@Autowired
private UserDataRepositoryInterface userDataRepositoryInterface;
    // Ajout equipement
    @GetMapping("/ajoutEquipmentArmes")
    public String ajoutEquipmentArmes() {
        Armes epeeBronze = new Armes("Epee Bronze");
        Armes epeeArgent = new Armes("Epee Argent");
        Armes epeeGold = new Armes("Epee Gold");
        Armes epeeAdminTKT = new Armes("Epee Admin");
        epeeBronze.setValeurATK(10);
        epeeArgent.setValeurATK(20);
        epeeGold.setValeurATK(30);
        epeeAdminTKT.setValeurATK(100);
        equipmentRepositoryInterface.save(epeeBronze);
        equipmentRepositoryInterface.save(epeeArgent);
        equipmentRepositoryInterface.save(epeeGold);
        equipmentRepositoryInterface.save(epeeAdminTKT);
        return "OK";
    }

    @GetMapping("/ajoutEquipmentArmures")
    public String ajoutEquipmentArmures() {
        Armures armuresBronze = new Armures("Armures Bronze");
        Armures armuresArgent = new Armures("Armures Argent");
        Armures armuresGold = new Armures("Armures Gold");
        Armures armuresAdmin = new Armures("Armures Admin");
        armuresBronze.setValeurDEF(10);
        armuresArgent.setValeurDEF(20);
        armuresGold.setValeurDEF(30);
        armuresAdmin.setValeurDEF(100);
        equipmentRepositoryInterface.save(armuresBronze);
        equipmentRepositoryInterface.save(armuresArgent);
        equipmentRepositoryInterface.save(armuresGold);
        equipmentRepositoryInterface.save(armuresAdmin);
        return "OK";
    }

    @GetMapping("/ajoutEquipmentAccessoires")
    public String ajoutEquipmentAccessoires() {
        Accessoires accessoiresBronze = new Accessoires("Bottes Bronze");
        Accessoires accessoiresArgent = new Accessoires("Bottes Argent");
        Accessoires accessoiresGold = new Accessoires("Bottes Gold");
        Accessoires accessoiresAdmin = new Accessoires("Bottes Admin");
        accessoiresBronze.setValeurVIT(10);
        accessoiresArgent.setValeurVIT(20);
        accessoiresGold.setValeurVIT(30);
        accessoiresAdmin.setValeurVIT(100);
        equipmentRepositoryInterface.save(accessoiresBronze);
        equipmentRepositoryInterface.save(accessoiresArgent);
        equipmentRepositoryInterface.save(accessoiresGold);
        equipmentRepositoryInterface.save(accessoiresAdmin);
        return "OK";
    }

    @GetMapping("/ajoutAdmin")
    public String ajoutAdmin() {
        Personnage p = personnageRepositoryInterface.findById(1);
        Armes a = armesRepositoryInterface.findById(4);
        p.setPerso_equip(a);
        personnageRepositoryInterface.save(p);
        return "OK";
    }

    @GetMapping("/recupAdmin")
    public Personnage recupAdmin() {
        return personnageRepositoryInterface.findById(1);
    }

    @GetMapping("/ajoutPersonnages")
    public String ajoutPersonnages() {
        Personnage heros = new Personnage("heros2", 200, 100, 10, 100, 100, 100, 1000);
        personnageRepositoryInterface.save(heros);
        return "OK";
    }

    @GetMapping("/combatMonstres/{id_ennemi}/{id}")
    public String combatEnnemi(@PathVariable int id_ennemi,@PathVariable int id) {

       int idd=userDataRepositoryInterface.findById(id).getForm_personnage().getID();
        String resutl=Game.combat( personnageRepositoryInterface.findById(idd), personnageRepositoryInterface.findById(id_ennemi));

        return resutl; }

    @GetMapping("/getEnnemi/{id}")
    public String getEnnemi(@PathVariable int id){
        return combatEnnemi(id,1);

    }


    @GetMapping("/envoiData")
    public List<Personnage> envoiData(){
        return personnageRepositoryInterface.findAll();
    }

}
