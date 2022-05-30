package com.projetspring.WorldsOfLikes.controllers;


import com.projetspring.WorldsOfLikes.beans.*;
import com.projetspring.WorldsOfLikes.repositories.EquipmentRepositoryInterface;
import com.projetspring.WorldsOfLikes.repositories.PersonnageRepositoryInterface;
import com.projetspring.WorldsOfLikes.services.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Game")
public class GameController {

    //Create DB
    @Autowired
    private PersonnageRepositoryInterface personnageRepositoryInterface;
    @Autowired
    private EquipmentRepositoryInterface equipmentRepositoryInterface;

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



    @GetMapping("/ajoutPersonnages")
    public String ajoutPersonnages() {
        Personnage heros = new Personnage("heros", 100, 100, 10, 100, 100, 100, 1000);

        return "OK";
    }

    @GetMapping("/ajoutCombatMonstres/{ennemi}")
    public String combatEnnemi(@RequestBody Personnage ennemi) {
        Personnage heros = new Personnage("heros", 100, 100, 10, 100, 100, 100, 1000);
        return Game.combat(heros, ennemi);
    }


}
