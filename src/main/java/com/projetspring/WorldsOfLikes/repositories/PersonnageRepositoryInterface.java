package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonnageRepositoryInterface extends JpaRepository<Personnage, Integer> {

   Personnage findById(int Id);

}
